package com.stopboot.admin.service.test.test4;

import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.mapper.mybatis.SbAdminMapper;
import com.stopboot.admin.entity.SbAdmin;
import com.stopboot.admin.entity.SbAdminExample;
import com.stopboot.admin.base.service.DefaultServiceImpl;
import com.stopboot.admin.model.test.test4.add.Test4AddParams;
import com.stopboot.admin.model.test.test4.list.Test4ListVO;
import com.stopboot.admin.model.test.test4.list.Test4ListParams;
import com.stopboot.admin.model.test.test4.one.Test4OneParams;
import com.stopboot.admin.model.test.test4.one.Test4OneVO;
import com.stopboot.admin.model.test.test4.page.Test4PageParams;
import com.stopboot.admin.model.test.test4.page.Test4PageVO;
import com.stopboot.admin.model.test.test4.update.Test4UpdateParams;
import com.stopboot.admin.model.test.test4.delete.Test4DeleteParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @description:  Test4 service
 * @author: Lianyutao
 * @create: 2019/11/01 18:30
 * @version: 1.0.1
**/

@Slf4j
@Service
public class Test4ServiceImpl extends DefaultServiceImpl<SbAdminMapper, SbAdmin, SbAdminExample,
        Test4PageVO, Test4ListVO, Test4OneVO,
        Test4PageParams, Test4ListParams, Test4OneParams,
        Test4AddParams, Test4UpdateParams, Test4DeleteParams>
        implements Test4ServiceI {


    @Override
    public PageResult<Test4PageVO> page(Test4PageParams pageParams) {
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
