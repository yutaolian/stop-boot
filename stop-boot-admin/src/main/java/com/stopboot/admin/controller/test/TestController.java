package com.stopboot.admin.controller.test;

import com.alibaba.fastjson.JSON;
import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.model.menu.tree.MenuTreeVOParams;
import com.stopboot.admin.model.test.TestPageVO;
import com.stopboot.admin.model.test.TestPageVOParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

    @PostMapping("page")
    public ResultData<TestPageVO> page(@RequestBody TestPageVOParams parms){
        ResultData build = ResultData.build();




        return build;
    }





}
