package com.russ4stall.webapp;

import com.russ4stall.crappie.controller.CrappieController;
import com.russ4stall.crappie.result.CrappieResult;
import com.russ4stall.crappie.result.Raw;

/**
 * Created by russellf on 3/1/2016.
 */
public class StaticController extends CrappieController {

    public CrappieResult index() {

        return new Raw("your mom");
    }
}
