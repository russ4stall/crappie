package com.russ4stall.crappie.result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Russ Forstall
 */
/*public abstract class CrappieResult {
    public abstract Object execute(Object o);
}*/
public abstract class CrappieResult {
    HttpServletRequest request;
    HttpServletResponse response;

    public CrappieResult() {
    }

    public abstract Object handle();

    public final void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public final void setResponse(HttpServletResponse response) {
        this.response = response;
    }
}
