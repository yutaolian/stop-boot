package com.stopboot.admin.controller.system.dept;

import com.stopboot.admin.base.controller.DefaultController;
import com.stopboot.admin.model.system.dept.add.DeptAddParams;
import com.stopboot.admin.model.system.dept.list.DeptListParams;
import com.stopboot.admin.model.system.dept.list.DeptListVO;
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
 * @create: 2019/11/04 20:04
 * @version: 1.0.1
 **/

@Slf4j
@RestController
@RequestMapping("/system/dept")
public class DeptController extends DefaultController<DeptServiceI,
        DeptPageVO,DeptListVO,DeptOneVO,
        DeptPageParams, DeptListParams,  DeptOneParams,
        DeptAddParams, DeptUpdateParams, DeptDeleteParams> {


}
