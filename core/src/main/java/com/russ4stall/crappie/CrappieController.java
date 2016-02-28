package com.russ4stall.crappie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Russ Forstall
 */

public abstract class CrappieController {
    HttpServletRequest request;
    HttpServletResponse response;

    public CrappieController(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public String doMethod() {
        return request.getParameter("name");
    }
}
