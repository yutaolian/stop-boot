package com.stopboot.admin.service.test;

import com.stopboot.admin.base.service.DefaultServiceI;
import com.stopboot.admin.model.test.add.TestAddParams;
import com.stopboot.admin.model.test.delete.TestDeleteParams;
import com.stopboot.admin.model.test.one.TestOneParams;
import com.stopboot.admin.model.test.one.TestOneVO;
import com.stopboot.admin.model.test.page.TestPageParams;
import com.stopboot.admin.model.test.page.TestPageVO;
import com.stopboot.admin.model.test.update.TestUpdateParams;


public interface TestServiceI extends DefaultServiceI<TestPageVO, TestOneVO, TestPageParams, TestOneParams, TestAddParams, TestUpdateParams, TestDeleteParams> {

}
