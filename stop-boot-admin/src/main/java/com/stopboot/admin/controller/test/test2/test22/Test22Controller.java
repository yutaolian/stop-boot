package com.stopboot.admin.controller.test.test2.test22;

import com.stopboot.admin.base.controller.DefaultController;
import com.stopboot.admin.model.test.test2.test22.add.Test22AddParams;
import com.stopboot.admin.model.test.test2.test22.list.Test22ListParams;
import com.stopboot.admin.model.test.test2.test22.list.Test22ListVO;
import com.stopboot.admin.model.test.test2.test22.one.Test22OneParams;
import com.stopboot.admin.model.test.test2.test22.one.Test22OneVO;
import com.stopboot.admin.model.test.test2.test22.page.Test22PageParams;
import com.stopboot.admin.model.test.test2.test22.page.Test22PageVO;
import com.stopboot.admin.model.test.test2.test22.update.Test22UpdateParams;
import com.stopboot.admin.model.test.test2.test22.delete.Test22DeleteParams;
import com.stopboot.admin.service.test.test2.test22.Test22ServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/11/01 17:09
 * @version: 1.0.1
 **/

@Slf4j
@RestController
@RequestMapping("/test/test2/test22")
public class Test22Controller extends DefaultController<Test22ServiceI,
        Test22PageVO,Test22ListVO,Test22OneVO,
        Test22PageParams, Test22ListParams,  Test22OneParams,
        Test22AddParams, Test22UpdateParams, Test22DeleteParams> {


}
