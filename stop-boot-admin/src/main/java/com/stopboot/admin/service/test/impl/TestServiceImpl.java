package com.stopboot.admin.service.test.impl;

import com.alibaba.fastjson.JSON;
import com.stopboot.admin.base.BaseServiceImpl;
import com.stopboot.admin.cache.test.TestCache;
import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.dao.mybatis.mapper.SbTestMapper;
import com.stopboot.admin.entity.SbTest;
import com.stopboot.admin.entity.SbTestExample;
import com.stopboot.admin.model.test.add.TestAddParams;
import com.stopboot.admin.model.test.delete.TestDeleteParams;
import com.stopboot.admin.model.test.detail.TestOneParams;
import com.stopboot.admin.model.test.detail.TestOneVO;
import com.stopboot.admin.model.test.page.TestPageParams;
import com.stopboot.admin.model.test.page.TestPageVO;
import com.stopboot.admin.model.test.update.TestUpdateParams;
import com.stopboot.admin.service.test.TestServiceI;
import com.stopboot.admin.utils.BeansHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-19 11:18
 * @version:
 **/

@Slf4j
@Service
public class TestServiceImpl extends BaseServiceImpl<SbTestMapper, SbTest, SbTestExample> implements TestServiceI {

    @Resource
    private TestCache testCache;

    @Override
    public PageResult<TestPageVO> page(TestPageParams params) {
        SbTestExample sbTestExample = new SbTestExample();
        PageResult<SbTest> sbTestPageResult = this.pageByExample(sbTestExample, params.getPageNum(), params.getPageSize());
        PageResult<TestPageVO> testPageVOPageResult = BeansHelper.getInstance().convert(sbTestPageResult, TestPageVO.class);
        return testPageVOPageResult;
    }

    @Override
    public TestOneVO one(TestOneParams params) {
        boolean b = testCache.setOne("1", this.selectByPrimaryKey(1));
        SbTest sbTest = testCache.loadOne("1");
        System.out.println("sbTest" + JSON.toJSONString(sbTest));
        boolean b1 = testCache.setOneCacheById(1);
        System.out.println("b1:" + b1);
        SbTest oneCacheById = testCache.getOneCacheById(1);
        log.info("sbtest:{}", sbTest);
        testCache.deleteOneCacheById(1);
        return null;
    }

    @Override
    public boolean update(TestUpdateParams params) {
        SbTest sbTest = (SbTest) BeansHelper.getInstance().convert(params, SbTest.class);
        return this.updateByPrimaryKeySelective(sbTest) > 0 ? true : false;
    }

    @Override
    public boolean delete(TestDeleteParams params) {
        return this.deleteByPrimaryKey(params.getId()) > 0 ? true : false;
    }

    @Override
    public boolean add(TestAddParams params) {
        SbTest sbTest = (SbTest) BeansHelper.getInstance().convert(params, SbTest.class);
        return this.insertSelective(sbTest) > 0 ? true : false;
    }
}
