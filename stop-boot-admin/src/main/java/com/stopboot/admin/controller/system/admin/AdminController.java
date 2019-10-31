package com.stopboot.admin.controller.system.admin;

import com.stopboot.admin.base.controller.DefaultController;
import com.stopboot.admin.model.system.admin.add.AdminAddParams;
import com.stopboot.admin.model.system.admin.list.AdminListParams;
import com.stopboot.admin.model.system.admin.list.AdminListVO;
import com.stopboot.admin.model.system.admin.one.AdminOneParams;
import com.stopboot.admin.model.system.admin.one.AdminOneVO;
import com.stopboot.admin.model.system.admin.page.AdminPageParams;
import com.stopboot.admin.model.system.admin.page.AdminPageVO;
import com.stopboot.admin.model.system.admin.update.AdminUpdateParams;
import com.stopboot.admin.model.system.admin.delete.AdminDeleteParams;
import com.stopboot.admin.service.system.admin.AdminServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/10/31 16:45
 * @version: 1.0.1
 **/

@Slf4j
@RestController
@RequestMapping("/system/admin")
public class AdminController extends DefaultController<AdminServiceI,
        AdminPageVO,AdminListVO,AdminOneVO,
        AdminPageParams, AdminListParams,  AdminOneParams,
        AdminAddParams, AdminUpdateParams, AdminDeleteParams> {


}
