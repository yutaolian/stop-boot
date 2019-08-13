package com.stopboot.admin.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @description: test
 * @author: Lianyutao
 * @create: 2019-08-13 16:20
 * @version:
 **/
@RestController
public class TestController {

//    @Resource
//    @Qualifier("master")
//    private DataSource dataSource;


    @RequestMapping("test")
    public String test(){

        return "hello world";
    }
}
