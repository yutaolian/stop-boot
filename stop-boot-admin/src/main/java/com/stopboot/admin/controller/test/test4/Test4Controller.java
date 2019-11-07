package com.stopboot.admin.controller.test.test4;

import com.stopboot.admin.base.controller.DefaultController;
import com.stopboot.admin.model.test.test4.add.Test4AddParams;
import com.stopboot.admin.model.test.test4.list.Test4ListParams;
import com.stopboot.admin.model.test.test4.list.Test4ListVO;
import com.stopboot.admin.model.test.test4.one.Test4OneParams;
import com.stopboot.admin.model.test.test4.one.Test4OneVO;
import com.stopboot.admin.model.test.test4.page.Test4PageParams;
import com.stopboot.admin.model.test.test4.page.Test4PageVO;
import com.stopboot.admin.model.test.test4.update.Test4UpdateParams;
import com.stopboot.admin.model.test.test4.delete.Test4DeleteParams;
import com.stopboot.admin.service.test.test4.Test4ServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/11/06 18:22
 * @version: 1.0.1
 **/

@Slf4j
@RestController
@RequestMapping("/test/test4")
public class Test4Controller extends DefaultController<Test4ServiceI,
        Test4PageVO,Test4ListVO,Test4OneVO,
        Test4PageParams, Test4ListParams,  Test4OneParams,
        Test4AddParams, Test4UpdateParams, Test4DeleteParams> {


}
