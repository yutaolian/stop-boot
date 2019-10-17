package com.stopboot.admin.annotation;


import com.stopboot.admin.db.DataSourceEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据源注解
 */

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SbDataSource {
    DataSourceEnum value() default DataSourceEnum.DB_MASTER;
}
