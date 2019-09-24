package com.stopboot.admin.common;

public interface FailCodeAndMsg {

    //默认错误
    String FAIL_CODE_DEFAULT = "00000";

    String FAIL_MSG_DEFAULT = "未知错误";

    //参数错误
    String FAIL_CODE_PARAMS = "10001";

    String FAIL_MSG_PARAMS = "%s:参数为空或类型错误";


    //
}
