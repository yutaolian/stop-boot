package com.stopboot.admin.service.admin;

import com.stopboot.admin.base.service.DefaultListServiceI;
import com.stopboot.admin.model.test.add.TestAddParams;
import com.stopboot.admin.model.test.one.TestOneParams;
import com.stopboot.admin.model.test.one.TestOneVO;
import com.stopboot.admin.model.test.list.TestListParams;
import com.stopboot.admin.model.test.list.TestListVO;
import com.stopboot.admin.model.test.page.TestPageParams;
import com.stopboot.admin.model.test.page.TestPageVO;
import com.stopboot.admin.model.test.update.TestUpdateParams;


/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-19 11:18
 * @version:
 **/
public interface AdminServiceI extends DefaultListServiceI<TestPageVO, TestListVO, TestOneVO, TestPageParams,
        TestListParams, TestOneParams, TestAddParams, TestUpdateParams> {

}
