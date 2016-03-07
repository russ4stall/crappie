package com.russ4stall.crappie.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by russellf on 3/4/2016.
 */
public class CrappieHelpers {

    protected static void printAttributes(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
