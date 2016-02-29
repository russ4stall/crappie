package com.russ4stall.crappie.route;

import com.russ4stall.crappie.action.CrappieAction;
import com.russ4stall.crappie.controller.Craptroller;
import com.russ4stall.crappie.result.CrappieResult;

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
                    String route = controller.getRoute() + action.getRoute() ;

                    actionManifest.put(route, action);
                }
            }
        }

        return actionManifest;
    }
}
