package com.russ4stall.webapp;

import com.russ4stall.crappie.controller.CrappieController;
import com.russ4stall.crappie.result.CrappieResult;
import com.russ4stall.crappie.result.Raw;

/**
 * @author Russ Forstall
 */
public class AdminController extends CrappieController {

    public CrappieResult index() {

        return new Raw("index action!!!!");
    }

    public CrappieResult test() {

        return new Raw("test action!!!!");
    }
}
