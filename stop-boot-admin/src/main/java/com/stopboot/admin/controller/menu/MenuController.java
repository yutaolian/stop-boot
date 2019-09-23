package com.stopboot.admin.controller.menu;

import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.model.menu.list.MenuListVO;
import com.stopboot.admin.model.menu.list.MenuListVOParams;
import com.stopboot.admin.model.menu.tree.MenuTreeVOParams;
import com.stopboot.admin.model.menu.tree.MenuTreeVO;
import com.stopboot.admin.service.menu.MenuServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
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
    public ResultData<MenuTreeVO> menuTree(@RequestBody MenuTreeVOParams params) {
        ResultData resultData = ResultData.build();
        List<MenuTreeVO> menuTreeList = menuServiceI.getMenuTree(params);
        if (!ObjectUtils.isEmpty(menuTreeList)) {
            resultData.success().setData(menuTreeList);
        } else {
            resultData.empty();
        }
        return resultData;
    }

    @PostMapping("list")
    public ResultData<MenuListVO> menuList(@RequestBody MenuListVOParams params) {
        ResultData resultData = ResultData.build();
        List<MenuListVO> menuTreeList = menuServiceI.getMenuList(params);
        if (!ObjectUtils.isEmpty(menuTreeList)) {
            resultData.success().setData(menuTreeList);
        } else {
            resultData.empty();
        }
        return resultData;
    }


}
