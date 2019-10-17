package com.stopboot.admin.controller.test;

import com.stopboot.admin.base.controller.DefaultSimpleController;
import com.stopboot.admin.base.simple.BaseSimpleParams;
import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.entity.SbTest;
import com.stopboot.admin.model.test.one.Test2OneParams;
import com.stopboot.admin.model.test.one.Test3OneParams;
import com.stopboot.admin.service.test.TestServiceI;
import com.stopboot.admin.service.test2.Test2ServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-15 20:10
 * @version:
 **/

@Slf4j
@RestController
@RequestMapping("test/test2")
public class Test2Controller extends DefaultSimpleController<TestServiceI, SbTest, BaseSimpleParams> {

    @Resource
    private Test2ServiceI test2ServiceI;

    @PostMapping("one1")
    public ResultData<SbTest> one1(@Validated @RequestBody Test2OneParams params) {
        ResultData build = ResultData.build();
        PageResult<SbTest> one1 = test2ServiceI.page(params);
        return build.success(one1);
    }
    @PostMapping("one2")
    public ResultData<SbTest> one2(@Validated @RequestBody Test3OneParams params) {
        ResultData build = ResultData.build();
        PageResult<SbTest> one1 = test2ServiceI.page(params);
        return build.success(one1);
    }
}
