package com.russ4stall.crappie.result;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by russellf on 3/1/2016.
 */
public class JSP extends CrappieResult {
    private String jspPath;
    private Object model;

    public JSP(String jspPath) {
        this.jspPath = jspPath;
        this.model = null;
    }

    public JSP(String jspPath, Object model) {
        this.jspPath = jspPath;
        this.model = model;
    }

    @Override
    public Object handle() {

        if (model != null) {
            //TODO map model fields to attributes
            request.setAttribute("model", model);
            //request.setAttribute(model.getClass().getSimpleName(), model);
        }

        try {
            request.getRequestDispatcher(jspPath).forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
