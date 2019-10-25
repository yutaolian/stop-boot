package com.stopboot.admin.service.system.dept;

import com.stopboot.admin.base.service.DefaultServiceI;
import com.stopboot.admin.model.system.dept.add.DeptAddParams;
import com.stopboot.admin.model.system.dept.one.DeptOneParams;
import com.stopboot.admin.model.system.dept.one.DeptOneVO;
import com.stopboot.admin.model.system.dept.page.DeptPageParams;
import com.stopboot.admin.model.system.dept.page.DeptPageVO;
import com.stopboot.admin.model.system.dept.update.DeptUpdateParams;
import com.stopboot.admin.model.system.dept.delete.DeptDeleteParams;


public interface DeptServiceI extends DefaultServiceI<DeptPageVO,DeptOneVO,
                                DeptPageParams, DeptOneParams,
                                DeptAddParams,DeptUpdateParams, DeptDeleteParams> {

}
