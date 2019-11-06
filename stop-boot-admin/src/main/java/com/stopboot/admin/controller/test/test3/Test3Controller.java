package com.stopboot.admin.controller.test.test3;

import com.stopboot.admin.base.controller.DefaultController;
import com.stopboot.admin.model.test.test3.add.Test3AddParams;
import com.stopboot.admin.model.test.test3.list.Test3ListParams;
import com.stopboot.admin.model.test.test3.list.Test3ListVO;
import com.stopboot.admin.model.test.test3.one.Test3OneParams;
import com.stopboot.admin.model.test.test3.one.Test3OneVO;
import com.stopboot.admin.model.test.test3.page.Test3PageParams;
import com.stopboot.admin.model.test.test3.page.Test3PageVO;
import com.stopboot.admin.model.test.test3.update.Test3UpdateParams;
import com.stopboot.admin.model.test.test3.delete.Test3DeleteParams;
import com.stopboot.admin.service.test.test3.Test3ServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/11/06 20:56
 * @version: 1.0.1
 **/

@Slf4j
@RestController
@RequestMapping("/test/test3")
public class Test3Controller extends DefaultController<Test3ServiceI,
        Test3PageVO,Test3ListVO,Test3OneVO,
        Test3PageParams, Test3ListParams,  Test3OneParams,
        Test3AddParams, Test3UpdateParams, Test3DeleteParams> {


}
