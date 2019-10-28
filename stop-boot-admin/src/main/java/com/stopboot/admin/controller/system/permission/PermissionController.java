package com.stopboot.admin.controller.system.permission;

import com.stopboot.admin.common.FailCodeAndMsg;
import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.model.menu.list.MenuListParams;
import com.stopboot.admin.model.menu.list.MenuListVO;
import com.stopboot.admin.model.system.permission.add.PermissionAddParams;
import com.stopboot.admin.model.system.permission.list.PermissionMenuListParams;
import com.stopboot.admin.model.system.permission.list.PermissionMenuListVO;
import com.stopboot.admin.service.system.menu.MenuServiceI;
import com.stopboot.admin.service.system.permission.PermissionServiceI;
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
 * @description: 权限
 * @author: Lianyutao
 * @create: 2019-09-24 11:21
 * @version:
 **/
@Slf4j
@RestController
@RequestMapping("system/permission")
public class PermissionController {

    @Resource
    private PermissionServiceI permissionService;

    @PostMapping("list")
    public ResultData<PermissionMenuListVO> menuList(@RequestBody PermissionMenuListParams params) {
        ResultData resultData = ResultData.build();
        List<PermissionMenuListVO> menuTreeList = permissionService.permissionMenuList(params);
        if (!ObjectUtils.isEmpty(menuTreeList)) {
            resultData.success().setData(menuTreeList);
        } else {
            resultData.empty();
        }
        return resultData;
    }


    /**
     * 添加
     *
     * @param params
     * @return
     */
    @PostMapping("add")
    public ResultData add(@Validated @RequestBody PermissionAddParams params) {
        ResultData resultData = ResultData.build();
        boolean flag = permissionService.add(params);
        if (flag) {
            resultData.success();
        } else {
            resultData.fail().setFailCode(FailCodeAndMsg.FAIL_CODE_ADD).setFailMsg(FailCodeAndMsg.FAIL_MSG_ADD);
        }
        return resultData;
    }
}
