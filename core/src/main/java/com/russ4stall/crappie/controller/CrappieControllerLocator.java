package com.russ4stall.crappie.controller;

import java.util.Set;

/**
 * @author Russ Forstall
 *
 * A ControllerLocator implementation will provide the strategy for
 * finding the classes that are controllers.
 */
public interface CrappieControllerLocator {
    /**
     *
     * @param p The package to search for controllers.
     * @param clazz The web app's contextListener implementation.
     * @return A list of classes that are controllers.
     */
    Set<Class<?>> findControllers(Class clazz);
}
