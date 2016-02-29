package com.russ4stall.crappie.result;

/**
 * @author Russ Forstall
 * Result that returns raw text to client.
 */
public class Raw implements CrappieResult {
    String s;

    public Raw(String s) {
        this.s = s;
    }

    public Object handle() {
        return s;
    }
}
