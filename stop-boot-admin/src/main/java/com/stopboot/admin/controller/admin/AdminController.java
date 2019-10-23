package com.stopboot.admin.controller.admin;

import com.stopboot.admin.base.controller.DefaultController;
import com.stopboot.admin.entity.SbAdmin;
import com.stopboot.admin.model.test.add.TestAddParams;
import com.stopboot.admin.model.test.delete.TestDeleteParams;
import com.stopboot.admin.model.test.one.TestOneParams;
import com.stopboot.admin.model.test.page.TestPageParams;
import com.stopboot.admin.model.test.update.TestUpdateParams;
import com.stopboot.admin.service.admin.AdminServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-15 13:57
 * @version:
 **/
@Slf4j
@RestController
@RequestMapping("admin")
public class AdminController extends DefaultController<AdminServiceI
        , SbAdmin, SbAdmin, TestPageParams
        , TestOneParams, TestAddParams, TestUpdateParams, TestDeleteParams> {


}
