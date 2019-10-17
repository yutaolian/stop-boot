package com.stopboot.admin.aspect;

import com.stopboot.admin.annotation.InvokeTime;
import com.stopboot.admin.annotation.SbDataSource;
import com.stopboot.admin.db.DataSourceEnum;
import com.stopboot.admin.db.DynamicDataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.omg.SendingContext.RunTime;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-19 20:28
 * @version:
 **/
@Aspect
@Order(-1)
@Component
public class InvokeTimeAspect {

    private long startTime;

    @Pointcut("execution(* com.stopboot.admin.base.service.BaseServiceImpl.*(..))")
    public void pointCut() {
    }

    @Before("@annotation(invokeTime)")
    public void doBefore(InvokeTime invokeTime) {
        this.startTime = System.currentTimeMillis();
    }

    @After("@annotation(invokeTime)")
    public void doAfter(InvokeTime invokeTime) {
        //接收到请求，记录请求内容
        long endTime = System.currentTimeMillis();
        System.out.println("===============invokeTime:" + (endTime - this.startTime) + "ms");
    }
}
