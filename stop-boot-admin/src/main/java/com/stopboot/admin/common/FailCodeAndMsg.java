package com.stopboot.admin.common;


/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-19 11:18
 * @version:
 **/

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

    //删除错误
    String FAIL_CODE_DELETE = "10031";

    String FAIL_MSG_DELETE = "删除失败";

    //删除错误
    String FAIL_CODE_ADD = "10041";

    String FAIL_MSG_ADD = "删除失败";

    //用户名或密码错误
    String FAIL_CODE_LOGIN = "10051";

    String FAIL_MSG_LOGIN  = "用户名或密码错误";

    //用户已被锁定
    String FAIL_CODE_USER_DISABLE = "10052";

    String FAIL_MSG_USER_DISABLE  = "用户已被锁定";

    //用户不存在
    String FAIL_CODE_USER_NO_EXIST = "10053";

    String FAIL_MSG_USER_NO_EXIST  = "用户不存在";


    //dickey存在
    String FAIL_CODE_DIC_KEY_EXIST = "50010";

    String FAIL_MSG_DIC_KEY_EXIST  = "字典key%s存在";


}
