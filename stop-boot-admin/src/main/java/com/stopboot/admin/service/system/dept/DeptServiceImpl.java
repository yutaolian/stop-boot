package com.stopboot.admin.service.system.dept;

import com.stopboot.admin.mapper.mybatis.SbDeptMapper;
import com.stopboot.admin.entity.SbDept;
import com.stopboot.admin.entity.SbDeptExample;
import com.stopboot.admin.base.service.DefaultServiceImpl;
import com.stopboot.admin.model.system.dept.add.DeptAddParams;
import com.stopboot.admin.model.system.dept.one.DeptOneParams;
import com.stopboot.admin.model.system.dept.one.DeptOneVO;
import com.stopboot.admin.model.system.dept.page.DeptPageParams;
import com.stopboot.admin.model.system.dept.page.DeptPageVO;
import com.stopboot.admin.model.system.dept.update.DeptUpdateParams;
import com.stopboot.admin.model.system.dept.delete.DeptDeleteParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @description:  Dept service
 * @author: Lianyutao
 * @create: 2019/10/25 12:16
 * @version: 1.0.1
**/

@Slf4j
@Service
public class DeptServiceImpl extends DefaultServiceImpl<SbDeptMapper, SbDept, SbDeptExample,
                                DeptPageVO, DeptOneVO,
                                DeptPageParams, DeptOneParams,
                                DeptAddParams, DeptUpdateParams, DeptDeleteParams>
                                implements DeptServiceI {



}
