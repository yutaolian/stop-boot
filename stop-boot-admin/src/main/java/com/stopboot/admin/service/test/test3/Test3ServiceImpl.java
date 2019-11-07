package com.stopboot.admin.service.test.test3;

import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.mapper.mybatis.SbTestMapper;
import com.stopboot.admin.entity.SbTest;
import com.stopboot.admin.entity.SbTestExample;
import com.stopboot.admin.base.service.DefaultServiceImpl;
import com.stopboot.admin.model.test.test3.add.Test3AddParams;
import com.stopboot.admin.model.test.test3.list.Test3ListVO;
import com.stopboot.admin.model.test.test3.list.Test3ListParams;
import com.stopboot.admin.model.test.test3.one.Test3OneParams;
import com.stopboot.admin.model.test.test3.one.Test3OneVO;
import com.stopboot.admin.model.test.test3.page.Test3PageParams;
import com.stopboot.admin.model.test.test3.page.Test3PageVO;
import com.stopboot.admin.model.test.test3.update.Test3UpdateParams;
import com.stopboot.admin.model.test.test3.delete.Test3DeleteParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @description:  Test3 service
 * @author: Lianyutao
 * @create: 2019/11/06 20:56
 * @version: 1.0.1
**/

@Slf4j
@Service
public class Test3ServiceImpl extends DefaultServiceImpl<SbTestMapper, SbTest, SbTestExample,
        Test3PageVO, Test3ListVO, Test3OneVO,
        Test3PageParams, Test3ListParams, Test3OneParams,
        Test3AddParams, Test3UpdateParams, Test3DeleteParams>
        implements Test3ServiceI {


    @Override
    public PageResult<Test3PageVO> page(Test3PageParams pageParams) {
        SbTestExample example = new SbTestExample();
        SbTestExample.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(pageParams.getId())) {
            criteria.andIdEqualTo(pageParams.getId());
        }
        if (!ObjectUtils.isEmpty(pageParams.getName())) {
            criteria.andNameEqualTo(pageParams.getName());
        }
        if (!ObjectUtils.isEmpty(pageParams.getAge())) {
            criteria.andAgeEqualTo(pageParams.getAge());
        }
        if (!ObjectUtils.isEmpty(pageParams.getBirthday())) {
            criteria.andBirthdayEqualTo(pageParams.getBirthday());
        }
        if (!ObjectUtils.isEmpty(pageParams.getCreateTime())) {
            criteria.andCreateTimeEqualTo(pageParams.getCreateTime());
        }
        if (!ObjectUtils.isEmpty(pageParams.getStatus())) {
            criteria.andStatusEqualTo(pageParams.getStatus());
        }
        if (!ObjectUtils.isEmpty(pageParams.getHeadImg())) {
            criteria.andHeadImgEqualTo(pageParams.getHeadImg());
        }
        if (!ObjectUtils.isEmpty(pageParams.getDeleteFlag())) {
            criteria.andDeleteFlagEqualTo(pageParams.getDeleteFlag());
        }
        if (!ObjectUtils.isEmpty(pageParams.getUpdateTime())) {
            criteria.andUpdateTimeEqualTo(pageParams.getUpdateTime());
        }
        return this.pageByExample(pageParams, example);
    }

}
