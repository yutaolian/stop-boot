package com.stopboot.admin.service.system.dept;

import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.mapper.mybatis.SbDeptMapper;
import com.stopboot.admin.entity.SbDept;
import com.stopboot.admin.entity.SbDeptExample;
import com.stopboot.admin.base.service.DefaultServiceImpl;
import com.stopboot.admin.model.system.dept.add.DeptAddParams;
import com.stopboot.admin.model.system.dept.list.DeptListVO;
import com.stopboot.admin.model.system.dept.list.DeptListParams;
import com.stopboot.admin.model.system.dept.one.DeptOneParams;
import com.stopboot.admin.model.system.dept.one.DeptOneVO;
import com.stopboot.admin.model.system.dept.page.DeptPageParams;
import com.stopboot.admin.model.system.dept.page.DeptPageVO;
import com.stopboot.admin.model.system.dept.update.DeptUpdateParams;
import com.stopboot.admin.model.system.dept.delete.DeptDeleteParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @description:  Dept service
 * @author: Lianyutao
 * @create: 2019/11/04 20:04
 * @version: 1.0.1
**/

@Slf4j
@Service
public class DeptServiceImpl extends DefaultServiceImpl<SbDeptMapper, SbDept, SbDeptExample,
        DeptPageVO, DeptListVO, DeptOneVO,
        DeptPageParams, DeptListParams, DeptOneParams,
        DeptAddParams, DeptUpdateParams, DeptDeleteParams>
        implements DeptServiceI {


    @Override
    public PageResult<DeptPageVO> page(DeptPageParams pageParams) {
        SbDeptExample example = new SbDeptExample();
        SbDeptExample.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(pageParams.getId())) {
            criteria.andIdEqualTo(pageParams.getId());
        }
        if (!ObjectUtils.isEmpty(pageParams.getCreateTime())) {
            criteria.andCreateTimeEqualTo(pageParams.getCreateTime());
        }
        if (!ObjectUtils.isEmpty(pageParams.getUpdateTime())) {
            criteria.andUpdateTimeEqualTo(pageParams.getUpdateTime());
        }
        if (!ObjectUtils.isEmpty(pageParams.getOpUserId())) {
            criteria.andOpUserIdEqualTo(pageParams.getOpUserId());
        }
        if (!ObjectUtils.isEmpty(pageParams.getStatus())) {
            criteria.andStatusEqualTo(pageParams.getStatus());
        }
        if (!ObjectUtils.isEmpty(pageParams.getDeleteFlag())) {
            criteria.andDeleteFlagEqualTo(pageParams.getDeleteFlag());
        }
        return this.pageByExample(pageParams, example);
    }

}
