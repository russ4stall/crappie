package com.russ4stall.crappie.route;

import com.russ4stall.crappie.action.CrappieAction;
import com.russ4stall.crappie.controller.CrappieController;
import com.russ4stall.crappie.controller.Craptroller;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**
 * @author Russ Forstall
 *
 * A RouteBuilder implementation will provide the strategy for
 * creating the routes that map to the controller methods.
 */
public interface CrappieRouteBuilder {
    Map<String, CrappieAction> buildRoutes(Set<Craptroller> controllers);
}
