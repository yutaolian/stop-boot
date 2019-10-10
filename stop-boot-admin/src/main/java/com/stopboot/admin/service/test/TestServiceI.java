package com.stopboot.admin.service.test;

import com.stopboot.admin.base.BaseServiceI;
import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.entity.SbTest;
import com.stopboot.admin.entity.SbTestExample;
import com.stopboot.admin.model.test.add.TestAddParams;
import com.stopboot.admin.model.test.delete.TestDeleteParams;
import com.stopboot.admin.model.test.detail.TestOneParams;
import com.stopboot.admin.model.test.detail.TestOneVO;
import com.stopboot.admin.model.test.page.TestPageParams;
import com.stopboot.admin.model.test.page.TestPageVO;
import com.stopboot.admin.model.test.update.TestUpdateParams;


public interface TestServiceI extends BaseServiceI<SbTest, SbTestExample> {

    PageResult<TestPageVO> page(TestPageParams params);

    TestOneVO one(TestOneParams params);

    boolean update(TestUpdateParams params);

    boolean delete(TestDeleteParams params);

    boolean add(TestAddParams params);
}
