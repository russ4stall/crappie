package com.russ4stall.crappie.result;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Russ Forstall
 * Result that returns raw text to client.
 */
public class Raw extends CrappieResult {
    String s;

    public Raw(String s) {
        this.s = s;
    }

    public Object handle() {
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        writer.print(s);
        return s;
    }
}
