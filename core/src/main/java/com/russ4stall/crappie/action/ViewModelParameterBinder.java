package com.russ4stall.crappie.action;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Russ Forstall
 */
public class ViewModelParameterBinder implements CrappieParameterBinder {
    @Override
    public List<Object> bindParameters(Map<String, String[]> reqParams, Parameter[] methodParams) {
        List<Object> paramValues = new ArrayList<>();
        Class<?> modelClass = methodParams[0].getType();
        Object model = null;
        try {
            model = modelClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, String[]> e : reqParams.entrySet()) {
            try {
                BeanUtils.setProperty(model, e.getKey(), e.getValue());
            } catch (IllegalAccessException | InvocationTargetException e1) {
                e1.printStackTrace();
            }
        }

        paramValues.add(model);

        return paramValues;
    }
}
