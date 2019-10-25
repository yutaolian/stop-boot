package com.stopboot.admin.controller.test.test1;

import com.stopboot.admin.base.controller.DefaultController;
import com.stopboot.admin.model.test.test1.add.Test1AddParams;
import com.stopboot.admin.model.test.test1.one.Test1OneParams;
import com.stopboot.admin.model.test.test1.one.Test1OneVO;
import com.stopboot.admin.model.test.test1.page.Test1PageParams;
import com.stopboot.admin.model.test.test1.page.Test1PageVO;
import com.stopboot.admin.model.test.test1.update.Test1UpdateParams;
import com.stopboot.admin.model.test.test1.delete.Test1DeleteParams;
import com.stopboot.admin.service.test.test1.Test1ServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/10/25 19:02
 * @version: 1.0.1
 **/

@Slf4j
@RestController
@RequestMapping("/test/test1")
public class Test1Controller extends DefaultController<Test1ServiceI,
                                Test1PageVO,Test1OneVO,
                                Test1PageParams, Test1OneParams,
                                Test1AddParams, Test1UpdateParams, Test1DeleteParams> {


}
