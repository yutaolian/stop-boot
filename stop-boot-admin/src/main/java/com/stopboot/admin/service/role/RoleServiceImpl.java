package com.stopboot.admin.service.role;

import com.stopboot.admin.base.service.BaseServiceImpl;
import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.dao.mybatis.mapper.SbRoleMapper;
import com.stopboot.admin.entity.SbRole;
import com.stopboot.admin.entity.SbRoleExample;
import com.stopboot.admin.model.role.list.RoleListVOParams;
import com.stopboot.admin.model.role.list.RoleListVO;
import com.stopboot.admin.model.role.page.RolePageVOParams;
import com.stopboot.admin.model.role.page.RolePageVO;
import com.stopboot.admin.utils.BeansHelper;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-19 11:18
 * @version:
 **/

@Service
public class RoleServiceImpl extends BaseServiceImpl<SbRoleMapper, SbRole, SbRoleExample> implements RoleServiceI {

    @Override
    public List<RoleListVO> getRoleList(RoleListVOParams params) {
        SbRoleExample sbRoleExample = new SbRoleExample();
        SbRoleExample.Criteria criteria = sbRoleExample.createCriteria();
        criteria.andDeleteFlagEqualTo(1);
        List<SbRole> sbRoles = this.selectByExample(sbRoleExample);
        List<RoleListVO> roleListVOList = BeansHelper.getInstance().convert(sbRoles, RoleListVO.class);
        return roleListVOList;
    }

    @Override
    public PageResult<RolePageVO> getRolePage(RolePageVOParams params) {
        SbRoleExample sbRoleExample = new SbRoleExample();
        SbRoleExample.Criteria criteria = sbRoleExample.createCriteria();
        criteria.andDeleteFlagEqualTo(1);
        PageResult<SbRole> sbRolePageResult = this.pageByExample(sbRoleExample, params.getPageNum(), params.getPageSize());
        if (sbRolePageResult.getList().size() > 0) {
            PageResult<RolePageVO>  pageResult = new PageResult<>();
            pageResult.copyInfo(sbRolePageResult);
            List<RolePageVO> roleListVOList = BeansHelper.getInstance().convert(sbRolePageResult.getList(), RoleListVO.class);
            pageResult.setList(roleListVOList);
            return pageResult;
        }else {
            return null;
        }
    }
}
