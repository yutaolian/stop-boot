package com.stopboot.admin.controller.system.permission;

import com.stopboot.admin.base.controller.DefaultController;
import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.model.system.permission.add.PermissionAddParams;
import com.stopboot.admin.model.system.permission.list.PermissionListParams;
import com.stopboot.admin.model.system.permission.list.PermissionListVO;
import com.stopboot.admin.model.system.permission.one.PermissionOneParams;
import com.stopboot.admin.model.system.permission.one.PermissionOneVO;
import com.stopboot.admin.model.system.permission.page.PermissionPageParams;
import com.stopboot.admin.model.system.permission.page.PermissionPageVO;
import com.stopboot.admin.model.system.permission.update.PermissionUpdateParams;
import com.stopboot.admin.model.system.permission.delete.PermissionDeleteParams;
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
 * @description:
 * @author: Lianyutao
 * @create: 2019/10/29 19:16
 * @version: 1.0.1
 **/

@Slf4j
@RestController
@RequestMapping("/system/permission")
public class PermissionController extends DefaultController<PermissionServiceI,
        PermissionPageVO, PermissionListVO, PermissionOneVO,
        PermissionPageParams, PermissionListParams, PermissionOneParams,
        PermissionAddParams, PermissionUpdateParams, PermissionDeleteParams> {

    @Resource
    private PermissionServiceI permissionService;

    @PostMapping("list")
    @Override
    public ResultData<PermissionListVO> list(@Validated @RequestBody PermissionListParams params) {
        ResultData resultData = ResultData.build();
        List<PermissionListVO> menuTreeList = permissionService.list(params);
        if (!ObjectUtils.isEmpty(menuTreeList)) {
            resultData.success(menuTreeList);
        } else {
            resultData.empty();
        }
        return resultData;
    }


}
