package com.stopboot.admin.common;

/**
 * Created by lianyutao on 2017/7/13.
 */
public class ResCodeAndMsg {

    /*成功*/
    public static String CODE_SUCCESS = "SUCCESS";

    /*失败*/
    public static String CODE_FAIL = "FAIL";

    /*空*/
    public static String CODE_EMPTY = "EMPTY";

    /*异常*/
    public static String CODE_EXCEPTION = "EXCEPTION";

    //非法调用(未通过认证)
    public static String CODE_UNAUTHC = "UNAUTHC";

    //token 过期
    public static String CODE_EXPIRE = "EXPIRE";


    /*成功*/
    public static String MSG_SUCCESS = "成功";

    /*异常失败*/
    public static String MSG_FAIL = "操作失败,稍后再试!";

    /*异常失败*/
    public static String MSG_EMPTY = "查询结果为空.";

    /*异常*/
    public static String MSG_EXCEPTION = "系统异常,稍后再试!";

    //非法调用(未通过认证)
    public static String MSG_UNAUTHC = "鉴权失败";

    //非法调用(未通过认证)
    public static String MSG_EXPIRE = "Token已过期，请重新登录";




}
