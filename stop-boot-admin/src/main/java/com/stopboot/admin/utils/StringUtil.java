package com.stopboot.admin.utils;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-22 20:33
 * @description:
 **/

/**
 * @version:0.0.1
 *
 * @author: Lianyutao
 *
 * @create: 2019-10-22 20:33

 * @description:
 **/

public class StringUtil {

    /**
     * 首字母大写
     * @param name
     * @return
     */
    public static String captureName(String name) {
        char[] cs=name.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);

    }
}
