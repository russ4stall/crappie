package com.russ4stall.crappie;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Russ Forstall
 */
@WebServlet("/*")
public class CrappieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO: decipher route
        //TODO: load correct class per route (add option for dependency injection?)
        //      TODO: make map<(String) route, (String) fully qualified className>
        //
        //TODO: execute correct method per route

        ServletContext servletContext = getServletContext();
        servletContext.getAttribute("routeMap");

        String controllerName = req.getRequestURI();
        controllerName = controllerName.substring(1) + "Controller";

        CrappieController controller = null;
        try {
            controller = (CrappieController) Class.forName(controllerName).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        /*Method mth = myclass.getDeclaredMethod(methodName, params);
        Object obj = myclass.newInstance();
        String result = (String)mth.invoke(obj, args);*/
        PrintWriter out = resp.getWriter();
        out.println(controller.doMethod());

        //printAttributes(req, resp);
        //super.service(req, resp);
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
