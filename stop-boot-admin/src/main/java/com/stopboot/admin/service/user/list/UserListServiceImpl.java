package com.stopboot.admin.service.user.list;

import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.mapper.mybatis.SbAdminMapper;
import com.stopboot.admin.entity.SbAdmin;
import com.stopboot.admin.entity.SbAdminExample;
import com.stopboot.admin.base.service.DefaultServiceImpl;
import com.stopboot.admin.model.user.list.add.UserListAddParams;
import com.stopboot.admin.model.user.list.list.UserListListVO;
import com.stopboot.admin.model.user.list.list.UserListListParams;
import com.stopboot.admin.model.user.list.one.UserListOneParams;
import com.stopboot.admin.model.user.list.one.UserListOneVO;
import com.stopboot.admin.model.user.list.page.UserListPageParams;
import com.stopboot.admin.model.user.list.page.UserListPageVO;
import com.stopboot.admin.model.user.list.update.UserListUpdateParams;
import com.stopboot.admin.model.user.list.delete.UserListDeleteParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @description:  UserList service
 * @author: Lianyutao
 * @create: 2019/11/01 14:59
 * @version: 1.0.1
**/

@Slf4j
@Service
public class UserListServiceImpl extends DefaultServiceImpl<SbAdminMapper, SbAdmin, SbAdminExample,
        UserListPageVO, UserListListVO, UserListOneVO,
        UserListPageParams, UserListListParams, UserListOneParams,
        UserListAddParams, UserListUpdateParams, UserListDeleteParams>
        implements UserListServiceI {


    @Override
    public PageResult<UserListPageVO> page(UserListPageParams pageParams) {
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
