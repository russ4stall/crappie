package com.russ4stall.crappie.controller;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;

import java.util.Set;

/**
 * @author Russ Forstall
 * Finds all classes whose name ends with 'Controller'. Example: HomeController
 */
public class NamingConventionControllerLocator implements CrappieControllerLocator {
    public Set<Class<?>> findControllers(Class clazz) {
        Reflections reflections = new Reflections(clazz.getPackage().toString());

        Set<Class<?>> allClasses = reflections.getSubTypesOf(Object.class);

        for (Class c : allClasses) {
            if (!c.getName().endsWith("Controller")) {
                allClasses.remove(c);
            }
        }

        return allClasses;
    }
}
