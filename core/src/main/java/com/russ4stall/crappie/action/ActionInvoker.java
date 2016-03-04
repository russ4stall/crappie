package com.russ4stall.crappie.action;

import com.russ4stall.crappie.result.CrappieResult;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by russellf on 3/4/2016.
 */
public interface ActionInvoker {
    CrappieResult getResult(CrappieAction action, CrappieParameterBinder parameterBinder, HttpServletRequest request, HttpServletResponse response);
}
