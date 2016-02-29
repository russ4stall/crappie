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
        Reflections reflections = new Reflections(clazz.getPackage().getName(), new SubTypesScanner(false));
        Set<Class<? extends CrappieController>> rawControllers = reflections.getSubTypesOf(CrappieController.class);

        Set<Craptroller> controllers = rawControllers.stream().map(Craptroller::new).collect(Collectors.toSet());

        return controllers;
    }
}
