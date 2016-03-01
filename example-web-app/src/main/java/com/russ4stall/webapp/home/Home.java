package com.russ4stall.webapp.home;

import com.russ4stall.crappie.annotations.Controller;
import com.russ4stall.crappie.controller.CrappieController;
import com.russ4stall.crappie.result.CrappieResult;
import com.russ4stall.crappie.result.JSP;

/**
 * @author Russ Forstall
 */
@Controller
public class Home extends CrappieController {

    public CrappieResult submitForm() {

        TestModel model = new TestModel("Rusty", 12);

        return new JSP("/WEB-INF/display-model-fields.jsp", model);
    }
}
