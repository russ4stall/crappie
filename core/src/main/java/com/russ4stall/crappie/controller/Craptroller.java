package com.russ4stall.crappie.controller;

/**
 * @author Russ Forstall
 */
public class Craptroller {
    private Class<? extends CrappieController> controllerClass;

    public Craptroller(Class<? extends CrappieController> controllerClass) {
        this.controllerClass = controllerClass;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }
}
