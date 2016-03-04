package com.russ4stall.crappie.action;

import com.russ4stall.crappie.controller.CrappieController;
import com.russ4stall.crappie.result.CrappieResult;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by russellf on 3/4/2016.
 */
public class ActionInvokerImpl implements ActionInvoker {
    @Override
    public CrappieResult getResult(CrappieAction action, CrappieParameterBinder parameterBinder, HttpServletRequest request, HttpServletResponse response) {

        //TODO create instance of controller (dependencies?)
        Class <? extends CrappieController> controllerClass = (Class) action.getMethod().getDeclaringClass();
        CrappieController controllerInstance = null;
        try {
            controllerInstance =  controllerClass.newInstance();
            controllerInstance.setRequest(request);
            controllerInstance.setResponse(response);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        CrappieResult result = null;

        List<Object> parameters = null;
        if (action.getMethod().getParameters().length > 0) {
            parameters = parameterBinder.bindParameters(request.getParameterMap(), action.getMethod().getParameters());
        }

        try {
            if (action.getMethod().getParameters().length > 0) {
                result = (CrappieResult) action.getMethod().invoke(controllerInstance, parameters != null ? parameters.toArray() : new Object[0]);
            } else {
                result = (CrappieResult) action.getMethod().invoke(controllerInstance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
