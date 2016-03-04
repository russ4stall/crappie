package com.russ4stall.crappie.route;

import com.russ4stall.crappie.action.CrappieAction;
import com.russ4stall.crappie.controller.Craptroller;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**
 * @author Russ Forstall
 */
public class NamingConventionRouteMatcher implements CrappieRouteMatcher {
    public CrappieAction getAction(String uri, Map<String, CrappieAction> actionManifest) {
        uri = uri.substring(1);
        String[] pathParts = uri.split("/");

        if(pathParts.length == 0) {
            //TODO
            System.out.println("Root requested");
            return null;
        }

        return actionManifest.get(uri);
    }
}
