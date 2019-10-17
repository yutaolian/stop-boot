package com.stopboot.admin.annotation;


import java.lang.annotation.*;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-19 11:18
 * @version:
 **/

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface InvokeTime {
}
