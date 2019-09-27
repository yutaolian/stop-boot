package com.stopboot.admin.service.test;

import com.stopboot.admin.base.BaseServiceI;
import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.entity.SbTest;
import com.stopboot.admin.entity.SbTestExample;
import com.stopboot.admin.model.test.TestPageVO;
import com.stopboot.admin.model.test.TestPageVOParams;


public interface TestServiceI extends BaseServiceI<SbTest, SbTestExample> {

    PageResult<TestPageVO> getTestPage(TestPageVOParams params);

}
