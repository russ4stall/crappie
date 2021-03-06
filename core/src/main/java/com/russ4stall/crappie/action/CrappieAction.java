package com.russ4stall.crappie.action;

import com.russ4stall.crappie.result.CrappieResult;
import com.russ4stall.crappie.util.HttpMethod;
import com.russ4stall.crappie.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by russellf on 2/29/2016.
 */
public class CrappieAction {
    private Method method;
    private HttpMethod httpMethod;

    public CrappieAction(Method method) {
        this.method = method;
    }

    public CrappieResult executeMethod() {
        CrappieResult result = null;
        try {
            Object controllerInstance = method.getDeclaringClass().newInstance();
            result = (CrappieResult) method.invoke(controllerInstance);
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Method getMethod() {
        return method;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }
}
