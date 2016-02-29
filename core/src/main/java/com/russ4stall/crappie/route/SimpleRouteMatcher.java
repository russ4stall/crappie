package com.russ4stall.crappie.route;

import com.russ4stall.crappie.controller.Craptroller;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**
 * @author Russ Forstall
 */
public class SimpleRouteMatcher implements CrappieRouteMatcher {
    public Method getAction(String uri, Map<String, Craptroller> controllers) {
        uri = uri.substring(1);
        String[] pathParts = uri.split("/");

        if(pathParts.length == 0) {
            System.out.println("Root requested");
            return null;
        }

        String controllerName = pathParts[0];

        Craptroller craptroller = controllers.get(controllerName);

        if (pathParts.length == 1) {
            try {
                return craptroller.getControllerClass().getDeclaredMethod("index");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        System.out.println(craptroller.getControllerClass().getCanonicalName());



        return null;
    }
}
