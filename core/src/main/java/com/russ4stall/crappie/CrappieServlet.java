package com.russ4stall.crappie;

import com.russ4stall.crappie.action.CrappieAction;
import com.russ4stall.crappie.result.CrappieResult;
import com.russ4stall.crappie.route.CrappieRouteMatcher;
import com.russ4stall.crappie.route.NamingConventionRouteMatcher;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Russ Forstall
 */

@WebServlet("/")
public class CrappieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        Map<String, CrappieAction> actionManifest = (Map<String, CrappieAction>) servletContext.getAttribute("actionManifest");
        CrappieRouteMatcher routeMatcher = new NamingConventionRouteMatcher();
        CrappieAction action = routeMatcher.getAction(req.getRequestURI(), actionManifest);

        if(action == null) {
            //TODO: return 404
        }

        CrappieResult result = action.executeMethod();
        result.setRequest(req);
        result.setResponse(resp);

        result.handle();

        //printAttributes(req, resp);
    }

    private void printAttributes(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.println("Method: " + req.getMethod());
        out.println("URL: " + req.getRequestURL());
        out.println("URI: " + req.getRequestURI());
        out.println("Query String: " + req.getQueryString());

        out.println("Param Map: ");
        Map<String, String[]> pMap = req.getParameterMap();
        for (Map.Entry<String, String[]> e : pMap.entrySet()) {
            out.println(e.getKey() + " : " + Arrays.toString(e.getValue()));
        }

        out.println("Param Names: ");
        Enumeration<String> paramNames = req.getParameterNames();
        while(paramNames.hasMoreElements()){
            String param = paramNames.nextElement();
            out.println(param);
        }
    }
}
