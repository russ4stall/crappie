package com.russ4stall.crappie.controller;

import com.russ4stall.crappie.util.StringUtil;

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
