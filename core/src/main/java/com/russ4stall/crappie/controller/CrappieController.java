package com.russ4stall.crappie.controller;

import com.russ4stall.crappie.result.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.russ4stall.crappie.Crappie.TEMPLATE_ENGINE;

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

    protected CrappieResult view(TemplateEngine templateEngine, String path, Object model) {
        return new View(templateEngine, path, model);
    }

    protected CrappieResult view(String path, Object model) {
        TemplateEngine templateEngine = (TemplateEngine) servletContext.getAttribute(TEMPLATE_ENGINE);
        return new View(templateEngine, path, model);
    }
}
