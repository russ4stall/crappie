package com.russ4stall.webapp.admin;

import com.russ4stall.crappie.controller.CrappieController;
import com.russ4stall.crappie.result.CrappieResult;
import com.russ4stall.crappie.result.JSP;
import com.russ4stall.webapp.user.User;

/**
 * Created by russellf on 3/1/2016.
 */
public class AdminController extends CrappieController {

    public CrappieResult getForm() {

        return new JSP("/WEB-INF/admin/admin-form.jsp");
    }

    public CrappieResult submitForm(AdminFormModel model) {

        User user = model.getUser();

        System.out.println(user);

        return new JSP("/WEB-INF/display-model-fields.jsp", model);
    }
}
