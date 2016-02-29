package com.russ4stall.crappie.controller;

import java.util.Map;
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
     * @param clazz The web app's contextListener implementation.
     * @return A list of classes that are controllers.
     */
    Map<String, Craptroller> findControllers(Class clazz);
}
