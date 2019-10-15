package com.stopboot.admin.service.test.impl;

import com.stopboot.admin.base.DefaultServiceImpl;
import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.dao.mybatis.mapper.SbTestMapper;
import com.stopboot.admin.entity.SbTest;
import com.stopboot.admin.entity.SbTestExample;
import com.stopboot.admin.model.test.add.TestAddParams;
import com.stopboot.admin.model.test.detail.TestOneParams;
import com.stopboot.admin.model.test.detail.TestOneVO;
import com.stopboot.admin.model.test.page.TestPageParams;
import com.stopboot.admin.model.test.page.TestPageVO;
import com.stopboot.admin.model.test.update.TestUpdateParams;
import com.stopboot.admin.service.test.TestServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;



/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-19 11:18
 * @version:
 **/

@Slf4j
@Service
public class TestServiceImpl extends
        DefaultServiceImpl<SbTestMapper, SbTest, SbTestExample, TestPageVO, TestOneVO, TestPageParams, TestOneParams, TestAddParams, TestUpdateParams>
        implements TestServiceI {

    @Override
    public PageResult<TestPageVO> page(TestPageParams pageParams) {
        SbTestExample example = new SbTestExample();
        SbTestExample.Criteria criteria = example.createCriteria();
        criteria.andAgeEqualTo(14);
        return this.pageByExample(pageParams, example);
    }


    @Override
    public TestOneVO oneWithBLOBs(TestOneParams params) {
        return null;
    }
}
