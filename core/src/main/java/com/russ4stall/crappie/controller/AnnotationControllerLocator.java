package com.russ4stall.crappie.controller;

import com.russ4stall.crappie.annotations.Controller;
import org.reflections.Reflections;
import java.util.Set;

/**
 * @author Russ Forstall
 */
public class AnnotationControllerLocator implements CrappieControllerLocator {
    public Set<Class<?>> findControllers(Class clazz) {
        Reflections reflections = new Reflections(clazz.getPackage());

        return reflections.getTypesAnnotatedWith(Controller.class);
    }
}
