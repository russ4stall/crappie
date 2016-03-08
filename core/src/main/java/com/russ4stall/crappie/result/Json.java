package com.russ4stall.crappie.result;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by russellf on 3/7/2016.
 */
public class Json extends CrappieResult {
    Object object;

    public Json(Object object) {
        this.object = object;
    }

    @Override
    public Object handle() {
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        writer.print(gson.toJson(object));
        return object;
    }
}
