package com.stopboot.admin.controller.test;

import com.stopboot.admin.base.BaseController;
import com.stopboot.admin.common.FailCodeAndMsg;
import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.model.test.add.TestAddParams;
import com.stopboot.admin.model.test.delete.TestDeleteParams;
import com.stopboot.admin.model.test.detail.TestOneParams;
import com.stopboot.admin.model.test.detail.TestOneVO;
import com.stopboot.admin.model.test.page.TestPageParams;
import com.stopboot.admin.model.test.page.TestPageVO;
import com.stopboot.admin.model.test.update.TestUpdateParams;
import com.stopboot.admin.service.test.TestServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: test
 * @author: Lianyutao
 * @create: 2019-08-13 16:20
 * @version:
 **/

@Slf4j
@RestController
@RequestMapping("test")
public class TestController extends BaseController {

    @Resource
    private TestServiceI testService;

    @PostMapping("page")
    public ResultData<TestPageVO> page(@Validated @RequestBody TestPageParams params) {
        ResultData resultData = ResultData.build();
        PageResult<TestPageVO> testPage = testService.page(params);
        if (testPage != null) {
            resultData.success(testPage);
        } else {
            resultData.empty();
        }
        return resultData;
    }

    @PostMapping("one")
    public ResultData<TestPageVO> one(@Validated @RequestBody TestOneParams params) {
        ResultData resultData = ResultData.build();
        TestOneVO testDetail = testService.one(params);
        if (testDetail != null) {
            resultData.success(testDetail);
        } else {
            resultData.empty();
        }
        return resultData;
    }

    @PostMapping("update")
    public ResultData update(@Validated @RequestBody TestUpdateParams params) {
        ResultData resultData = ResultData.build();
        boolean flag = testService.update(params);
        if (flag) {
            resultData.success();
        } else {
            resultData.fail().setFailCode(FailCodeAndMsg.FAIL_CODE_UPDATE).setFailMsg(FailCodeAndMsg.FAIL_MSG_UPDATE);
        }
        return resultData;
    }

    @PostMapping("delete")
    public ResultData delete(@Validated @RequestBody TestDeleteParams params) {
        ResultData resultData = ResultData.build();
        boolean flag = testService.delete(params);
        if (flag) {
            resultData.success();
        } else {
            resultData.fail().setFailCode(FailCodeAndMsg.FAIL_CODE_DELETE).setFailMsg(FailCodeAndMsg.FAIL_MSG_DELETE);
        }
        return resultData;
    }

    @PostMapping("add")
    public ResultData add(@Validated @RequestBody TestAddParams params) {
        ResultData resultData = ResultData.build();
        boolean flag = testService.add(params);
        if (flag) {
            resultData.success();
        } else {
            resultData.fail().setFailCode(FailCodeAndMsg.FAIL_CODE_ADD).setFailMsg(FailCodeAndMsg.FAIL_MSG_ADD);
        }
        return resultData;
    }

}
