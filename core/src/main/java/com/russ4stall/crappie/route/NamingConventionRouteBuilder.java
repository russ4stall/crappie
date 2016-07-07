package com.russ4stall.crappie.route;

import com.russ4stall.crappie.action.CrappieAction;
import com.russ4stall.crappie.controller.Craptroller;
import com.russ4stall.crappie.result.CrappieResult;
import com.russ4stall.crappie.util.StringUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Russ Forstall
 * Uses the names of the controller and method to build the route.
 */
public class NamingConventionRouteBuilder implements CrappieRouteBuilder {
    @Override
    public Map<String, CrappieAction> buildRoutes(Set<Craptroller> controllers) {
        Map<String, CrappieAction> actionManifest = new HashMap<>();

        for (Craptroller controller : controllers) {
            Method[] methods = controller.getControllerClass().getDeclaredMethods();
            for (Method m : methods) {
                if (m.getReturnType() == CrappieResult.class) {
                    CrappieAction action = new CrappieAction(m);
                    String route = getControllerRoute(controller) + getActionRoute(action) ;

                    actionManifest.put(route, action);
                }
            }
        }

        return actionManifest;
    }

    private String getControllerRoute(Craptroller craptroller) {
        String s = craptroller.getControllerClass().getSimpleName();
        s = String.join("-", StringUtil.splitCamelCase(s));
        s = s.toLowerCase();
        if (s.endsWith("controller")) {
            s = s.substring(0, s.length() - 11);
        }
        
        if (s.equals("index")) {
            return "";
        }
        
        return s;
    }

    private String getActionRoute(CrappieAction action) {
        String s = action.getMethod().getName();
        s = String.join("-", StringUtil.splitCamelCase(s));
        s = s.toLowerCase();
        if (s.equals("index")) {
            return "";
        }
        return "/" + s;
    }

}
