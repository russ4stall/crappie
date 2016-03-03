package com.russ4stall.crappie.controller;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by russellf on 2/29/2016.
 */
public class CrappieControllerLocatorImpl implements CrappieControllerLocator {
    @Override
    public Set<Craptroller> findControllers(Class clazz) {
        Package package = clazz.getPackage();
        Reflections reflections;
        
        // If no package is specified, this will search the entire classpath for controllers
        if (package != null) {
            reflections = new Reflections(package.getName(), new SubTypesScanner(false));    
        } else {
            reflections = new Reflections();
        }
        
        Set<Class<? extends CrappieController>> rawControllers = reflections.getSubTypesOf(CrappieController.class);

        Set<Craptroller> controllers = rawControllers.stream().map(Craptroller::new).collect(Collectors.toSet());

        return controllers;
    }
}
