package com.stopboot.admin.service.system.admin;

import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.mapper.mybatis.SbAdminMapper;
import com.stopboot.admin.entity.SbAdmin;
import com.stopboot.admin.entity.SbAdminExample;
import com.stopboot.admin.base.service.DefaultServiceImpl;
import com.stopboot.admin.model.system.admin.add.AdminAddParams;
import com.stopboot.admin.model.system.admin.list.AdminListVO;
import com.stopboot.admin.model.system.admin.list.AdminListParams;
import com.stopboot.admin.model.system.admin.one.AdminOneParams;
import com.stopboot.admin.model.system.admin.one.AdminOneVO;
import com.stopboot.admin.model.system.admin.page.AdminPageParams;
import com.stopboot.admin.model.system.admin.page.AdminPageVO;
import com.stopboot.admin.model.system.admin.update.AdminUpdateParams;
import com.stopboot.admin.model.system.admin.delete.AdminDeleteParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @description:  Admin service
 * @author: Lianyutao
 * @create: 2019/10/31 16:45
 * @version: 1.0.1
**/

@Slf4j
@Service
public class AdminServiceImpl extends DefaultServiceImpl<SbAdminMapper, SbAdmin, SbAdminExample,
        AdminPageVO, AdminListVO, AdminOneVO,
        AdminPageParams, AdminListParams, AdminOneParams,
        AdminAddParams, AdminUpdateParams, AdminDeleteParams>
        implements AdminServiceI {


    @Override
    public PageResult<AdminPageVO> page(AdminPageParams pageParams) {
        SbAdminExample example = new SbAdminExample();
        SbAdminExample.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(pageParams.getId())) {
            criteria.andIdEqualTo(pageParams.getId());
        }
        if (!ObjectUtils.isEmpty(pageParams.getName())) {
            criteria.andNameEqualTo(pageParams.getName());
        }
        if (!ObjectUtils.isEmpty(pageParams.getMobile())) {
            criteria.andMobileEqualTo(pageParams.getMobile());
        }
        if (!ObjectUtils.isEmpty(pageParams.getPassword())) {
            criteria.andPasswordEqualTo(pageParams.getPassword());
        }
        if (!ObjectUtils.isEmpty(pageParams.getEmail())) {
            criteria.andEmailEqualTo(pageParams.getEmail());
        }
        if (!ObjectUtils.isEmpty(pageParams.getStatus())) {
            criteria.andStatusEqualTo(pageParams.getStatus());
        }
        if (!ObjectUtils.isEmpty(pageParams.getDeleteFlag())) {
            criteria.andDeleteFlagEqualTo(pageParams.getDeleteFlag());
        }
        if (!ObjectUtils.isEmpty(pageParams.getCreateTime())) {
            criteria.andCreateTimeEqualTo(pageParams.getCreateTime());
        }
        if (!ObjectUtils.isEmpty(pageParams.getUpdateTime())) {
            criteria.andUpdateTimeEqualTo(pageParams.getUpdateTime());
        }
        return this.pageByExample(pageParams, example);
    }

}
