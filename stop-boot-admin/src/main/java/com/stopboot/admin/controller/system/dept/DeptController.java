package com.stopboot.admin.controller.system.dept;

import com.stopboot.admin.base.controller.DefaultController;
import com.stopboot.admin.model.system.dept.add.DeptAddParams;
import com.stopboot.admin.model.system.dept.one.DeptOneParams;
import com.stopboot.admin.model.system.dept.one.DeptOneVO;
import com.stopboot.admin.model.system.dept.page.DeptPageParams;
import com.stopboot.admin.model.system.dept.page.DeptPageVO;
import com.stopboot.admin.model.system.dept.update.DeptUpdateParams;
import com.stopboot.admin.model.system.dept.delete.DeptDeleteParams;
import com.stopboot.admin.service.system.dept.DeptServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/10/25 12:16
 * @version: 1.0.1
 **/

@Slf4j
@RestController
@RequestMapping("/system/dept")
public class DeptController extends DefaultController<DeptServiceI,
                                DeptPageVO,DeptOneVO,
                                DeptPageParams, DeptOneParams,
                                DeptAddParams, DeptUpdateParams, DeptDeleteParams> {


}
