package com.stopboot.admin.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyFilter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 日志切面
 * @author: Lianyutao
 * @create: 2019-09-19 17:16
 * @version:
 **/
@Slf4j
@Aspect
@Configuration
public class LogAspect {

    /**
     * 切点方法实现
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Order(0)
    @Before("execution(* com.stopboot.admin.controller.*.*.*(..)) ")
    public void doLog(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String,Object> logMap = new HashMap<>(10);
        // 记录下请求内容
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(System.currentTimeMillis());
        logMap.put("TIME",time);
        logMap.put("URL",request.getRequestURL().toString());
        logMap.put("HTTP_METHOD",request.getMethod().toString());
        logMap.put("CLASS_METHOD",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logMap.put("URL",request.getRequestURL().toString());
        Enumeration<?> headerNames = request.getHeaderNames();
        Map headersMap = new HashMap();
        while (headerNames.hasMoreElements()) {
            String headName = (String) headerNames.nextElement();
            headersMap.put(headName,request.getHeader(headName));
        }
        logMap.put("HEADERS",headersMap);
        //获取所有参数方法一：
        Enumeration<String> enu = request.getParameterNames();
        Map getParams = new HashMap();
        while (enu.hasMoreElements()) {
            String paraName = enu.nextElement();
            getParams.put(paraName,request.getParameter(paraName));
        }
        logMap.put("GET_PARAMTERS",getParams);
        if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
            //默认取方法的第一个作为参数
            logMap.put("REQUEST_BODY", JSON.toJSONString(joinPoint.getArgs()[0]));
        }
        log.info(JSON.toJSONString(logMap));
    }
}
