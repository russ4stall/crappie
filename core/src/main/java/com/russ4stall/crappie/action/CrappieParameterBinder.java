package com.russ4stall.crappie.action;

import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Map;

/**
 * Created by russellf on 3/1/2016.
 */
public interface CrappieParameterBinder {
    List<Object> bindParameters(Map<String, String[]> reqParams, Parameter[] methodParams);

}
