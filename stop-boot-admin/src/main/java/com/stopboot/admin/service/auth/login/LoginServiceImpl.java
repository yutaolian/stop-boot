package com.stopboot.admin.service.auth.login;

import com.stopboot.admin.base.service.BaseServiceImpl;
import com.stopboot.admin.dao.mybatis.mapper.SbAdminMapper;
import com.stopboot.admin.entity.SbAdmin;
import com.stopboot.admin.entity.SbAdminExample;
import com.stopboot.admin.model.auth.login.LoginParams;
import com.stopboot.admin.model.auth.login.LoginVO;
import com.stopboot.admin.utils.BeansHelper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-12 14:56
 * @version:
 **/

@Service
public class LoginServiceImpl extends BaseServiceImpl<SbAdminMapper, SbAdmin, SbAdminExample> implements LoginServiceI {

    /**
     * 登录
     *
     * @param params
     * @return
     */
    @Override
    public LoginVO login(LoginParams params) {
        SbAdminExample sbAdminExample = new SbAdminExample();
        SbAdminExample.Criteria criteria = sbAdminExample.createCriteria();
        criteria.andMobileEqualTo(params.getMobile());
        criteria.andPasswordEqualTo(params.getPassword());
        List<SbAdmin> sbAdmins = this.selectByExample(sbAdminExample);
        if (sbAdmins!= null && sbAdmins.size() > 0){
            LoginVO loginVO = (LoginVO) BeansHelper.getInstance().convert(sbAdmins.get(0), LoginVO.class);
            //获得用户角色
            loginVO.setRoles(Arrays.asList("ROLE_ADMIN"));
            return loginVO;
        }
        return null;
    }
}
