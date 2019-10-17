package com.stopboot.admin.controller.test;

import com.stopboot.admin.base.controller.BaseController;
import com.stopboot.admin.model.test.add.TestAddParams;
import com.stopboot.admin.model.test.one.TestOneParams;
import com.stopboot.admin.model.test.one.TestOneVO;
import com.stopboot.admin.model.test.page.TestPageParams;
import com.stopboot.admin.model.test.page.TestPageVO;
import com.stopboot.admin.model.test.update.TestUpdateParams;
import com.stopboot.admin.service.test.TestServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @description:
* @author: Lianyutao
* @create: 2019-10-15 20:10
* @version:
**/

@Slf4j
@RestController
@RequestMapping("test/test2")
public class Test2Controller extends BaseController<TestServiceI, TestPageVO, TestOneVO, TestPageParams, TestOneParams, TestAddParams, TestUpdateParams> {


}
