/*
 * Copyright (c) 2016,gaosiedu.com
 */
package com.stopboot.admin.config;

import com.stopboot.admin.common.FailCodeAndMsg;
import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author lianyutao
 * @describe 全局异常处理
 * @date 2017/7/25 13:39
 * @since 2.1.0
 */

@Slf4j
@Configuration
@RestControllerAdvice
public class GlobalExceptionHandler {

    //处理其他所有异常
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultData exceptionHandler(MethodArgumentNotValidException e) {
        return ResultData.build().fail(FailCodeAndMsg.FAIL_CODE_PARAMS,
                e.getBindingResult().getFieldError().getField() + ":" + e.getBindingResult().getFieldError().getDefaultMessage());
    }

    //处理其他所有异常
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public ResultData exceptionHandler(HttpMessageNotReadableException e) {
        return ResultData.build().fail(FailCodeAndMsg.FAIL_CODE_PARAMS, "请求参数转换异常");
    }

    //处理其他所有异常
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ResultData exceptionHandler(BizException e) {
        return ResultData.build().fail(e.getFailCode(), e.getFailMsg());
    }
}
