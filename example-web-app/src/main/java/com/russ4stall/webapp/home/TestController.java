package com.russ4stall.webapp.home;

import com.russ4stall.crappie.controller.CrappieController;
import com.russ4stall.crappie.result.CrappieResult;
import com.russ4stall.crappie.result.Jsp;

/**
 * Created by russellf on 3/1/2016.
 */
public class TestController extends CrappieController {

    public CrappieResult index() {

        TestModel model = new TestModel("Russ", 26);

        return new Jsp("/WEB-INF/test.jsp", model);
    }

    public CrappieResult test(TestModel test) {
        return jsp("/WEB-INF/display-model-fields.jsp", test);
    }
}
