package com.russ4stall.crappie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by russellf on 2/29/2016.
 */
public abstract class CrappieController {
    HttpServletRequest request;
    HttpServletResponse response;

    public CrappieController() {
    }

    public String doMethod() {
        return request.getParameter("name");
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }
}
