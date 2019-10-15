package com.stopboot.admin.utils;

import java.lang.reflect.ParameterizedType;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-15 13:43
 * @version:
 **/

public class ClassUtil {

    public static Class<?> getClass(Class clazz, Integer index) {
        return (Class<?>) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[index];
    }
}
