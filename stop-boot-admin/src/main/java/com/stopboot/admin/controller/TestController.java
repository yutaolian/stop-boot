package com.stopboot.admin.controller;

import com.alibaba.fastjson.JSON;
import com.stopboot.admin.model.menu.tree.MenuTreeParams;
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
public class TestController {

//    @Resource
//    @Qualifier("master")
//    private DataSource dataSource;


    @RequestMapping("test")
    public String test(){
        return "hello world";
    }

    @PostMapping("menu/list")
    public Object menus(@RequestBody MenuTreeParams parms){
        log.debug(JSON.toJSONString(parms));

        String menus = "{\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"title\": \"首页\",\n" +
                "      \"path\": \"/\",\n" +
                "      \"component\": \"Layout\",\n" +
                "      \"icon\": \"index\",\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"title\": \"首页\",\n" +
                "          \"path\": \"/dashboard\",\n" +
                "          \"component\": \"dashboard\",\n" +
                "          \"icon\": \"index\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"用户管理\",\n" +
                "      \"path\": \"/user\",\n" +
                "      \"component\": \"Layout\",\n" +
                "      \"icon\": \"index\",\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"title\": \"个人中心\",\n" +
                "          \"path\": \"/center\",\n" +
                "          \"component\": \"/view/user/center\",\n" +
                "          \"icon\": \"user\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"title\": \"角色管理\",\n" +
                "          \"path\": \"/role\",\n" +
                "          \"component\": \"/view/user/role\",\n" +
                "          \"icon\": \"user\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        return JSON.parse(menus);
    }





}
