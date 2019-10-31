package com.stopboot.admin.service.system.admin;

import com.stopboot.admin.base.service.DefaultServiceI;
import com.stopboot.admin.model.system.admin.add.AdminAddParams;
import com.stopboot.admin.model.system.admin.list.AdminListVO;
import com.stopboot.admin.model.system.admin.list.AdminListParams;
import com.stopboot.admin.model.system.admin.one.AdminOneParams;
import com.stopboot.admin.model.system.admin.one.AdminOneVO;
import com.stopboot.admin.model.system.admin.page.AdminPageParams;
import com.stopboot.admin.model.system.admin.page.AdminPageVO;
import com.stopboot.admin.model.system.admin.update.AdminUpdateParams;
import com.stopboot.admin.model.system.admin.delete.AdminDeleteParams;


public interface AdminServiceI extends DefaultServiceI<AdminPageVO, AdminListVO, AdminOneVO,
        AdminPageParams, AdminListParams, AdminOneParams,
        AdminAddParams, AdminUpdateParams, AdminDeleteParams> {

}
