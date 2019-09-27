package com.stopboot.admin.service.test.impl;

import com.stopboot.admin.base.BaseServiceImpl;
import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.dao.mybatis.mapper.SbTestMapper;
import com.stopboot.admin.entity.SbTest;
import com.stopboot.admin.entity.SbTestExample;
import com.stopboot.admin.model.role.list.RoleListVO;
import com.stopboot.admin.model.test.TestPageVO;
import com.stopboot.admin.model.test.TestPageVOParams;
import com.stopboot.admin.service.test.TestServiceI;
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
public class TestServiceImpl extends BaseServiceImpl<SbTestMapper, SbTest, SbTestExample> implements TestServiceI {

    @Override
    public PageResult<TestPageVO> getTestPage(TestPageVOParams params) {
        SbTestExample sbTestExample = new SbTestExample();
        PageResult<SbTest> sbTestPageResult = this.pageByExample(sbTestExample, params.getPageNum(), params.getPageSize());
        PageResult<TestPageVO> testPageVOPageResult = BeansHelper.getInstance().convert(sbTestPageResult, RoleListVO.class);
        return testPageVOPageResult;
    }
}
