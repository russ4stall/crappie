package com.russ4stall.crappie.controller;

import com.russ4stall.crappie.annotations.Controller;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Russ Forstall
 *
 * Finds all controllers
 */
public class AnnotationControllerLocator implements CrappieControllerLocator {
    public Map<String, Craptroller> findControllers(Class clazz) {
        Reflections reflections = new Reflections(clazz.getPackage().getName(), new SubTypesScanner(false));
        Set<Class<?>> rawControllers = reflections.getTypesAnnotatedWith(Controller.class);

        Map<String, Craptroller> controllers = new HashMap();
        for (Class<?> c : rawControllers) {
            controllers.put(c.getSimpleName().toLowerCase(), new Craptroller(c));
        }
        return controllers;
    }
}
