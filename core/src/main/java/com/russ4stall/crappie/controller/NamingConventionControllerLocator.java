package com.russ4stall.crappie.controller;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Russ Forstall
 * Finds all classes whose name ends with 'Controller'. Example: HomeController
 */
public class NamingConventionControllerLocator implements CrappieControllerLocator {
    public Map<String, Craptroller> findControllers(Class clazz) {
        Reflections reflections = new Reflections(clazz.getPackage().getName(), new SubTypesScanner(false));
        Set<Class<?>> allClasses = reflections.getSubTypesOf(Object.class);
        Map<String, Craptroller> controllers = new HashMap();

        for (Class c : allClasses) {
            if (c.getName().endsWith("Controller")) {
                String s = c.getSimpleName().substring(0, c.getSimpleName().length() - 10).toLowerCase();
                controllers.put(s, new Craptroller(c, s));
            }
        }

        return controllers;
    }
}
