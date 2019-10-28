package com.stopboot.admin.controller.system.menu;

import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.model.menu.list.MenuListParams;
import com.stopboot.admin.model.menu.list.MenuListVO;
import com.stopboot.admin.service.system.menu.MenuServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("system/menu")
public class MenuController {

    @Resource
    private MenuServiceI menuService;

    @PostMapping("list")
    public ResultData<MenuListVO> list(@Validated @RequestBody MenuListParams params) {
        ResultData resultData = ResultData.build();
        List<MenuListVO> menuTreeList = menuService.list(params);
        if (!ObjectUtils.isEmpty(menuTreeList)) {
            resultData.success(menuTreeList);
        } else {
            resultData.empty();
        }
        return resultData;
    }

//    List<MenuListVO> list(MenuListParams params) {
}
