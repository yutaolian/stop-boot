package com.stopboot.admin.service.role;

import com.stopboot.admin.base.BaseServiceI;
import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.entity.SbRole;
import com.stopboot.admin.entity.SbRoleExample;
import com.stopboot.admin.model.role.list.RoleListVOParams;
import com.stopboot.admin.model.role.list.RoleListVO;
import com.stopboot.admin.model.role.page.RolePageVOParams;
import com.stopboot.admin.model.role.page.RolePageVO;

import java.util.List;


public interface RoleServiceI extends BaseServiceI<SbRole, SbRoleExample> {

    List<RoleListVO> getRoleList(RoleListVOParams params);

    PageResult<RolePageVO> getRolePage(RolePageVOParams params);
}
