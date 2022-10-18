package com.summerproject.utils;

import com.summerproject.pojo.HistoryTracking;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    public static<T> T copyParamToBean(Map value, T bean){
        try {
            System.out.println("注入之前" + bean);
            BeanUtils.populate(bean, value);
            System.out.println("注入之后" + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String strInt, int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
