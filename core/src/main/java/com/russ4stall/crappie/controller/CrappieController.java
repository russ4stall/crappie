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

    public CrappieController(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public String doMethod() {
        return request.getParameter("name");
    }
}
