package com.russ4stall.crappie.util;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author Russ Forstall
 */
public class StringUtil {
    //accept a string, like aCamelString
    //return a list containing strings, in this case, [a, Camel, String]
    public static LinkedList<String> splitCamelCase(String s){
        LinkedList<String> result = new LinkedList<String>();
        Collections.addAll(result, s.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])"));
        return result;
    }
}
