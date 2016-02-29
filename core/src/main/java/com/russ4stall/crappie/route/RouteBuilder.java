package com.russ4stall.crappie.route;

import java.util.Map;
import java.util.Set;

/**
 * @author Russ Forstall
 *
 * A RouteBuilder implementation will provide the strategy for
 * creating the routes for the web app.
 */
public interface RouteBuilder {
    Map<String, Class<?>> buildRoutes(Set<Class<?>> controllers);
}
