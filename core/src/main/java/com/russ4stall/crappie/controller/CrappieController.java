package com.russ4stall.crappie.controller;

import com.russ4stall.crappie.result.CrappieResult;
import com.russ4stall.crappie.result.Json;
import com.russ4stall.crappie.result.Jsp;
import com.russ4stall.crappie.result.Raw;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by russellf on 2/29/2016.
 */
public abstract class CrappieController {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext servletContext;

    public CrappieController() { }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    protected CrappieResult jsp(String path, Object model) {
        return new Jsp(path, model);
    }

    protected CrappieResult json(Object model) {
        return new Json(model);
    }

    protected CrappieResult raw(String s) {
        return new Raw(s);
    }
}
