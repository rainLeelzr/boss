package com.rain.boss.util;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;

/**
 * 继承apache的PropertyUtils
 */
public class PropertyUtils extends org.apache.commons.beanutils.PropertyUtils {

    /**
     * 重新定义父类的describe方法，去掉父类方法结果中的"class" key
     *
     * @param bean 需要转换为map的对象
     */
    public static Map<String, Object> describe(final Object bean) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Map<String, Object> temp = org.apache.commons.beanutils.PropertyUtils.describe(bean);
        temp.remove("class");
        return temp;
    }

    /**
     * 增加describe方法的功能，去掉value为null或者为空字符串的key
     *
     * @param bean 需要转换为map的对象
     */
    public static Map<String, Object> describeWithoutBlank(final Object bean) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Map<String, Object> temp = describe(bean);
        Iterator<Map.Entry<String, Object>> it = temp.entrySet().iterator();
        it.forEachRemaining(entry -> {
            if (null == entry.getValue()) {
                it.remove();
            } else if (entry.getValue() instanceof String && StringUtils.isBlank((String) entry.getValue())) {
                it.remove();
            }
        });
        return temp;
    }

}
