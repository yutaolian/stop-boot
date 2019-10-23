package com.stopboot.admin.controller.test;

import com.stopboot.admin.base.controller.DefaultController;
import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.model.test.add.TestAddParams;
import com.stopboot.admin.model.test.delete.TestDeleteParams;
import com.stopboot.admin.model.test.one.TestOneParams;
import com.stopboot.admin.model.test.one.TestOneVO;
import com.stopboot.admin.model.test.list.TestListParams;
import com.stopboot.admin.model.test.list.TestListVO;
import com.stopboot.admin.model.test.page.TestPageParams;
import com.stopboot.admin.model.test.page.TestPageVO;
import com.stopboot.admin.model.test.update.TestUpdateParams;
import com.stopboot.admin.service.admin.AdminServiceI;
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
@RequestMapping("test/test1")
public class Test1Controller extends DefaultController<TestServiceI, TestPageVO, TestOneVO, TestPageParams, TestOneParams, TestAddParams, TestUpdateParams, TestDeleteParams> {

    @Resource
    private TestServiceI testService;

    @Resource
    private AdminServiceI adminServiceI;

    /**
     * @param params
     * @return
     */
    @PostMapping("list")
    public ResultData<TestListVO> list(@Validated @RequestBody TestListParams params) {
        ResultData resultData = ResultData.build();
        List<TestListVO> testPage = adminServiceI.list(params);
        if (testPage != null) {
            resultData.success(testPage);
        } else {
            resultData.empty();
        }
        return resultData;
    }
}
