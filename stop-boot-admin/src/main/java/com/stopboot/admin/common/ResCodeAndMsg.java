package com.stopboot.admin.common;

/**
 * Created by lianyutao on 2017/7/13.
 */
public interface ResCodeAndMsg {

    /*成功*/
     String CODE_SUCCESS = "SUCCESS";

    /*失败*/
     String CODE_FAIL = "FAIL";

    /*空*/
     String CODE_EMPTY = "EMPTY";

    //非法调用(未通过认证)
     String CODE_UNAUTHC = "UNAUTHC";

    //token 过期
     String CODE_EXPIRE = "EXPIRE";

    /*成功*/
     String MSG_SUCCESS = "成功";

    /*异常失败*/
     String MSG_FAIL = "操作失败,稍后再试!";

    /*异常失败*/
     String MSG_EMPTY = "查询结果为空.";

    //非法调用(未通过认证)
     String MSG_UNAUTHC = "鉴权失败";

    //非法调用(未通过认证)
     String MSG_EXPIRE = "Token已过期，请重新登录";




}
