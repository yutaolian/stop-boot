package com.stopboot.admin.common;

public interface FailCodeAndMsg {

    //默认错误
    String FAIL_CODE_DEFAULT = "00000";

    String FAIL_MSG_DEFAULT = "未知错误";

    //参数错误
    String FAIL_CODE_PARAMS = "10001";

    String FAIL_MSG_PARAMS = "%s:参数为空或类型错误";

    //
    //更新错误
    String FAIL_CODE_UPDATE = "10011";

    String FAIL_MSG_UPDATE = "更新失败";

    //更新错误
    String FAIL_CODE_DELETE = "10031";

    String FAIL_MSG_DELETE = "删除失败";

    //更新错误
    String FAIL_CODE_ADD = "10041";

    String FAIL_MSG_ADD = "添加失败";
}
