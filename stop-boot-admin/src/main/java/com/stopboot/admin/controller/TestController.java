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


    public static void main(String[] args) {
        String menus = "{\"data\":[{\"path\":\"/\",\"component\":\"Layout\",\"children\":[{\"path\":\"dashboard\",\"component\":\"dashboard\",\"icon\":\"index\",\"name\":\"dashboard\",\"title\":\"首页\"}],\"icon\":\"index\",\"title\":\"首页\"},{\"path\":\"/user\",\"component\":\"Layout\",\"children\":[{\"path\":\"center\",\"component\":\"user/center\",\"name\":\"userCenter\",\"icon\":\"user\",\"title\":\"个人中心\"},{\"path\":\"role\",\"component\":\"user/role\",\"name\":\"userRole\",\"icon\":\"user\",\"title\":\"角色管理\"}],\"icon\":\"index\",\"title\":\"用户管理\"},{\"path\":\"/course\",\"component\":\"Layout\",\"children\":[{\"path\":\"list\",\"component\":\"course/list\",\"name\":\"courseList\",\"icon\":\"user\",\"title\":\"课程列表\"},{\"path\":\"detail\",\"component\":\"course/detail\",\"name\":\"courseDetail\",\"icon\":\"user\",\"title\":\"课程详情\",\"hidden\":true}],\"icon\":\"index\",\"title\":\"课程管理\"}]}";

        System.out.println( JSON.parse(menus));
    }

    @RequestMapping("test")
    public String test(){
        return "hello world";
    }

    @PostMapping("menu/list")
    public Object menus(@RequestBody MenuTreeParams parms){
        log.debug(JSON.toJSONString(parms));
//        String menus = "{\"data\":[{\"path\":\"/\",\"component\":\"Layout\",\"children\":[{\"path\":\"dashboard\",\"component\":\"dashboard\",\"icon\":\"index\",\"title\":\"首页\"}],\"icon\":\"index\",\"title\":\"首页\"},{\"path\":\"/user\",\"component\":\"Layout\",\"children\":[{\"path\":\"center\",\"component\":\"user/center\",\"icon\":\"user\",\"title\":\"个人中心\"},{\"path\":\"role\",\"component\":\"user/role\",\"icon\":\"user\",\"title\":\"角色管理\"}],\"icon\":\"index\",\"title\":\"用户管理\"},{\"path\":\"/course\",\"component\":\"Layout\",\"children\":[{\"path\":\"list\",\"component\":\"course/list\",\"icon\":\"user\",\"title\":\"课程列表\"},{\"path\":\"detail\",\"component\":\"course/detail\",\"name\":\"courseDetail\",\"icon\":\"user\",\"title\":\"课程详情\",\"hidden\":true}],\"icon\":\"index\",\"title\":\"课程管理\"}]}";
        String menus = "{\"data\":[{\"path\":\"/\",\"component\":\"Layout\",\"children\":[{\"path\":\"dashboard\",\"component\":\"dashboard\",\"icon\":\"index\",\"name\":\"dashboard\",\"title\":\"首页\"}],\"icon\":\"index\",\"title\":\"首页\"},{\"path\":\"/user\",\"component\":\"Layout\",\"children\":[{\"path\":\"center\",\"component\":\"user/center\",\"name\":\"userCenter\",\"icon\":\"user\",\"title\":\"个人中心\"},{\"path\":\"role\",\"component\":\"user/role\",\"name\":\"userRole\",\"icon\":\"user\",\"title\":\"角色管理\"}],\"icon\":\"index\",\"title\":\"用户管理\"},{\"path\":\"/course\",\"component\":\"Layout\",\"children\":[{\"path\":\"list\",\"component\":\"course/list\",\"name\":\"courseList\",\"icon\":\"user\",\"title\":\"课程列表\"},{\"path\":\"detail\",\"component\":\"course/detail\",\"name\":\"courseDetail\",\"icon\":\"user\",\"title\":\"课程详情\",\"hidden\":true}],\"icon\":\"index\",\"title\":\"课程管理\"}]}";
        return JSON.parse(menus);
    }





}
