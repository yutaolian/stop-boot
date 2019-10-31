package com.stopboot.admin.mapper.mybatis;

import com.stopboot.admin.entity.SbRoleMenuPermissions;
import com.stopboot.admin.entity.SbRoleMenuPermissionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SbRoleMenuPermissionsMapper {
    int countByExample(SbRoleMenuPermissionsExample example);

    int deleteByExample(SbRoleMenuPermissionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SbRoleMenuPermissions record);

    int insertSelective(SbRoleMenuPermissions record);

    List<SbRoleMenuPermissions> selectByExample(SbRoleMenuPermissionsExample example);

    SbRoleMenuPermissions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SbRoleMenuPermissions record, @Param("example") SbRoleMenuPermissionsExample example);

    int updateByExample(@Param("record") SbRoleMenuPermissions record, @Param("example") SbRoleMenuPermissionsExample example);

    int updateByPrimaryKeySelective(SbRoleMenuPermissions record);

    int updateByPrimaryKey(SbRoleMenuPermissions record);
}