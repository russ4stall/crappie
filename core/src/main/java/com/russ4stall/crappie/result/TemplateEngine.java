package com.russ4stall.crappie.result;

/**
 * @author Russ Forstall
 */
public interface TemplateEngine {
    String render(String path, Object model);
}
