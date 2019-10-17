package com.stopboot.admin.service.auth.login;

import com.stopboot.admin.base.service.BaseServiceI;
import com.stopboot.admin.entity.SbAdmin;
import com.stopboot.admin.entity.SbAdminExample;
import com.stopboot.admin.model.auth.login.LoginParams;
import com.stopboot.admin.model.auth.login.LoginVO;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-12 14:55
 * @version:
 **/

public interface LoginServiceI extends BaseServiceI<SbAdmin, SbAdminExample> {

    /**
     * 登录
     * @param params
     * @return
     */
    LoginVO login(LoginParams params);
}
