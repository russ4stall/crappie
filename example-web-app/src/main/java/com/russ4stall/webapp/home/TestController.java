package com.russ4stall.webapp.home;

import com.russ4stall.crappie.controller.CrappieController;
import com.russ4stall.crappie.result.CrappieResult;
import com.russ4stall.crappie.result.JSP;

/**
 * Created by russellf on 3/1/2016.
 */
public class TestController extends CrappieController {

    public CrappieResult index() {

        TestModel model = new TestModel("Russ", 26);

        return new JSP("/WEB-INF/test.jsp", model);
    }
}
