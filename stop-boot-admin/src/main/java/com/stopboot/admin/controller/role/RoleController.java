package com.stopboot.admin.controller.role;

import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.model.role.list.RoleListVOParams;
import com.stopboot.admin.model.role.list.RoleListVO;
import com.stopboot.admin.model.role.page.RolePageVOParams;
import com.stopboot.admin.model.role.page.RolePageVO;
import com.stopboot.admin.service.role.RoleServiceI;
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
@RequestMapping("role")
public class RoleController {
    @Resource
    private RoleServiceI roleServiceI;

    @PostMapping("list")
    public ResultData<RoleListVO> roleList(@RequestBody RoleListVOParams params) {
        ResultData resultData = ResultData.build();
        List<RoleListVO> roleListVOList = roleServiceI.getRoleList(params);
        if (!ObjectUtils.isEmpty(roleListVOList)){
            resultData.success().setData(roleListVOList);
        }else{
            resultData.empty();
        }
        return resultData;
    }

    @PostMapping("page")
    public ResultData<RolePageVO> roleList(@RequestBody RolePageVOParams params) {
        ResultData resultData = ResultData.build();
        PageResult<RolePageVO> rolePageVOPageResult = roleServiceI.getRolePage(params);
        if (!ObjectUtils.isEmpty(rolePageVOPageResult)){
            resultData.success().setData(rolePageVOPageResult);
        }else{
            resultData.empty();
        }
        return resultData;
    }


}
