package com.stopboot.admin.service.admin;

import com.stopboot.admin.base.ListServiceI;
import com.stopboot.admin.model.test.add.TestAddParams;
import com.stopboot.admin.model.test.detail.TestOneParams;
import com.stopboot.admin.model.test.detail.TestOneVO;
import com.stopboot.admin.model.test.list.TestListParams;
import com.stopboot.admin.model.test.list.TestListVO;
import com.stopboot.admin.model.test.page.TestPageParams;
import com.stopboot.admin.model.test.page.TestPageVO;
import com.stopboot.admin.model.test.update.TestUpdateParams;

public interface AdminServiceI extends ListServiceI<TestPageVO, TestListVO, TestOneVO, TestPageParams,
        TestListParams, TestOneParams, TestAddParams, TestUpdateParams> {

}
