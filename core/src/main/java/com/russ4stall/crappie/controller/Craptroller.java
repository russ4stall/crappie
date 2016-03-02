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

    public String getRoute() {
        //TODO: if has @Route annotation, get route from arg

        String s = controllerClass.getSimpleName();
        s = String.join("-", StringUtil.splitCamelCase(s));
        s = s.toLowerCase();
        if (s.endsWith("controller")) {
            s = s.substring(0, s.length() - 11);
        }

        return s;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }
}
