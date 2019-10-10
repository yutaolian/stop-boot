package com.stopboot.admin.controller.test;

import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.model.test.detail.TestDetailParams;
import com.stopboot.admin.model.test.detail.TestDetailVO;
import com.stopboot.admin.model.test.page.TestPageVO;
import com.stopboot.admin.model.test.page.TestPageVOParams;
import com.stopboot.admin.service.test.TestServiceI;
import lombok.extern.slf4j.Slf4j;
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
public class TestController {

    @Resource
    private TestServiceI testService;

    @PostMapping("page")
    public ResultData<TestPageVO> page(@RequestBody TestPageVOParams params){
        ResultData resultData = ResultData.build();
        PageResult<TestPageVO> testPage = testService.getTestPage(params);
        if (testPage != null){
            resultData.success(testPage);
        }else{
            resultData.empty();
        }
        return resultData;
     }

    @PostMapping("one")
    public ResultData<TestPageVO> one(@RequestBody TestDetailParams params){
        ResultData resultData = ResultData.build();
        TestDetailVO testDetail = testService.getTestDetail(params);
        if (testDetail != null){
            resultData.success(testDetail);
        }else{
            resultData.empty();
        }
        return resultData;
     }
}
