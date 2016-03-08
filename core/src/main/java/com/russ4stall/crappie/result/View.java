package com.russ4stall.crappie.result;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Russ Forstall
 */
public class View extends CrappieResult {
    TemplateEngine templateEngine;
    String path;
    Object model;

    public View(TemplateEngine templateEngine, String path, Object model) {
        this.templateEngine = templateEngine;
        this.path = path;
        this.model = model;
    }

    @Override
    public Object handle() {
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (templateEngine != null) {
            String s = templateEngine.render(path, model);
            writer.print(s);
            return s;
        } else {
            try {
                throw new Exception("Template engine has not been set.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
