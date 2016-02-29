package com.russ4stall.crappie.controller;

/**
 * @author Russ Forstall
 */
public class Craptroller {
    private Class<?> controllerClass;
    private String route;

    public Craptroller(Class<?> controllerClass, String route) {
        this.controllerClass = controllerClass;
        this.route = route;
    }

    public Craptroller(Class<?> controllerClass) {
        this.controllerClass = controllerClass;
        this.route = controllerClass.getSimpleName().toLowerCase();
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public String getRoute() {
        return route;
    }
}
