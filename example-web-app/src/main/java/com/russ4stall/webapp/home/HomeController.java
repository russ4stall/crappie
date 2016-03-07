package com.russ4stall.webapp.home;

import com.russ4stall.crappie.controller.CrappieController;
import com.russ4stall.crappie.result.CrappieResult;
import com.russ4stall.crappie.result.Raw;

/**
 * @author Russ Forstall
 */
public class HomeController extends CrappieController {

    public CrappieResult index() {
        String s = "";

        request.getAttribute("name");

        return new Raw(s);
    }
}
