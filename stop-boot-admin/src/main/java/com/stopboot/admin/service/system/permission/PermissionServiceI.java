package com.stopboot.admin.service.system.permission;

import com.stopboot.admin.base.service.DefaultServiceI;
import com.stopboot.admin.model.help.generator.GeneratorInfo;
import com.stopboot.admin.model.system.permission.add.PermissionAddParams;
import com.stopboot.admin.model.system.permission.list.PermissionListParams;
import com.stopboot.admin.model.system.permission.list.PermissionListVO;
import com.stopboot.admin.model.system.permission.one.PermissionOneParams;
import com.stopboot.admin.model.system.permission.one.PermissionOneVO;
import com.stopboot.admin.model.system.permission.page.PermissionPageParams;
import com.stopboot.admin.model.system.permission.page.PermissionPageVO;
import com.stopboot.admin.model.system.permission.update.PermissionUpdateParams;
import com.stopboot.admin.model.system.permission.delete.PermissionDeleteParams;


public interface PermissionServiceI extends DefaultServiceI<PermissionPageVO, PermissionListVO, PermissionOneVO,
        PermissionPageParams, PermissionListParams, PermissionOneParams,
        PermissionAddParams, PermissionUpdateParams, PermissionDeleteParams> {


    /**
     * 代码生成工具生成默认权限
     * @param generatorInfo
     */
    void addGeneratorPermission(GeneratorInfo generatorInfo);
}
