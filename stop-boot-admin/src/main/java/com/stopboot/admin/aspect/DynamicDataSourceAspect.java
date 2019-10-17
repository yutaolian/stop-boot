package com.stopboot.admin.aspect;

import com.stopboot.admin.annotation.SbDataSource;
import com.stopboot.admin.db.DataSourceEnum;
import com.stopboot.admin.db.DynamicDataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @description: 数据源切换aspect
 * @author: Lianyutao
 * @create: 2019-09-19 15:17
 * @version:
 **/
@Aspect
@Order(-1)
@Component
public class DynamicDataSourceAspect {

    @Pointcut("execution(* com.stopboot.admin.base.service.BaseServiceImpl.*(..)) || " +
            "execution(* com.stopboot.admin.service.help.*.*.*(..)) ")
    public void pointCut() {
    }

    /**
     * 切入前设置数据源
//     * @param sbDataSource
     */
    @Before("@annotation(sbDataSource)")
    public void doBefore(SbDataSource sbDataSource) {
        DataSourceEnum value = sbDataSource.value();
        if (value == DataSourceEnum.DB_MASTER) {
            DynamicDataSourceContextHolder.set(DataSourceEnum.DB_MASTER);
        } else if (value == DataSourceEnum.DB_SLAVE) {
            DynamicDataSourceContextHolder.set(DataSourceEnum.DB_SLAVE);
        } else if (value == DataSourceEnum.DB_LOG) {
            DynamicDataSourceContextHolder.set(DataSourceEnum.DB_LOG);
        } else {
            DynamicDataSourceContextHolder.set(DataSourceEnum.DB_MASTER);
        }
    }

    /**
     * 切入后清空数据源
     * @param sbDataSource
     */
    @After("@annotation(sbDataSource)")
    public void doAfter(SbDataSource sbDataSource) {
        DynamicDataSourceContextHolder.clear();
    }
}
