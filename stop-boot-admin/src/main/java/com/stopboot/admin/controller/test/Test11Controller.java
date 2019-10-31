package com.stopboot.admin.controller.test;

import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.model.test.list.TestListParams;
import com.stopboot.admin.model.test.list.TestListVO;
import com.stopboot.admin.service.test.TestServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: test
 * @author: Lianyutao
 * @create: 2019-08-13 16:20
 * @version:
 **/

@Slf4j
@RestController
@RequestMapping("test/test11")
public class Test11Controller extends com.stopboot.admin.base.controller.AbstractBaseController {

    @Resource
    private TestServiceI testService;


    /**
     * @param params
     * @return
     */
    @PostMapping("list")
    public ResultData<TestListVO> list(@Validated @RequestBody TestListParams params) {
        ResultData resultData = ResultData.build();
        List<TestListVO> testPage = null;//testService.list(params);
        if (testPage != null) {
            resultData.success(testPage);
        } else {
            resultData.empty();
        }
        return resultData;
    }
}
