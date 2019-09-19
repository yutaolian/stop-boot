package com.stopboot.admin.controller.menu;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.entity.SbMenu;
import com.stopboot.admin.entity.SbMenuExample;
import com.stopboot.admin.model.menu.tree.MenuTree;
import com.stopboot.admin.model.menu.tree.MenuTreeParams;
import com.stopboot.admin.service.menu.MenuServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 菜单
 * @author: Lianyutao
 * @create: 2019-09-19 11:17
 * @version:
 **/
@Slf4j
@RestController
@RequestMapping("menu")
public class MenuController {
    @Resource
    private MenuServiceI menuServiceI;

    @PostMapping("tree")
    public ResultData<MenuTree> menuList(@RequestBody MenuTreeParams parms){
        ResultData resultData = ResultData.build();
        String menu = "[{\"path\":\"/\",\"component\":\"Layout\",\"children\":[{\"path\":\"dashboard\",\"component\":\"dashboard\",\"icon\":\"index\",\"name\":\"dashboard\",\"title\":\"首页\"}],\"name\":\"dashboard\",\"icon\":\"index\",\"title\":\"首页\"},{\"path\":\"/user\",\"component\":\"Layout\",\"name\":\"user\",\"children\":[{\"path\":\"center\",\"component\":\"user/center\",\"name\":\"userCenter\",\"icon\":\"user\",\"title\":\"个人中心\"},{\"path\":\"role\",\"component\":\"user/role\",\"name\":\"userRole\",\"icon\":\"user\",\"title\":\"角色管理\"}],\"icon\":\"index\",\"title\":\"用户管理\"},{\"path\":\"/course\",\"component\":\"Layout\",\"name\":\"course\",\"children\":[{\"path\":\"list\",\"component\":\"course/list\",\"name\":\"courseList\",\"icon\":\"user\",\"title\":\"课程列表\"},{\"path\":\"detail\",\"component\":\"course/detail\",\"hidden\":true,\"name\":\"courseDetail\",\"icon\":\"user\",\"title\":\"课程详情\"}],\"icon\":\"index\",\"title\":\"课程管理\"}]";
        List<MenuTree> menuTrees = JSON.parseArray(menu, MenuTree.class);
        resultData.success().setData(menuTrees);

        SbMenu sbMenu = menuServiceI.selectByPrimaryKey(3);

        System.out.println(JSON.toJSON(sbMenu));

        SbMenuExample sbMenuExample = new SbMenuExample();
        SbMenuExample.Criteria criteria = sbMenuExample.createCriteria();
        criteria.andIdEqualTo(3);
        List<SbMenu> sbMenus = menuServiceI.selectByExample(sbMenuExample);

        System.out.println(JSON.toJSON(sbMenus));
        sbMenu.setCode("11111");
        int i = menuServiceI.updateByExample(sbMenu, sbMenuExample);
        SbMenu sbMenu2 = menuServiceI.selectByPrimaryKey(3);
        System.out.println(JSON.toJSON(sbMenu2));
        return resultData;
    }



}
