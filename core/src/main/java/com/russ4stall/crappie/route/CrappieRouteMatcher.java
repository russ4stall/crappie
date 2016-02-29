package com.russ4stall.crappie.route;

import com.russ4stall.crappie.controller.Craptroller;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**
 * @author Russ Forstall
 *
 * Finds the correct method to invoke from the right controller
 */
public interface CrappieRouteMatcher {
    Method getAction(String uri, Map<String, Craptroller> controllers);
}
