package com.stopboot.admin.mapper.mybatis;

import com.stopboot.admin.entity.SbRolePermissions;
import com.stopboot.admin.entity.SbRolePermissionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SbRolePermissionsMapper {
    int countByExample(SbRolePermissionsExample example);

    int deleteByExample(SbRolePermissionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SbRolePermissions record);

    int insertSelective(SbRolePermissions record);

    List<SbRolePermissions> selectByExample(SbRolePermissionsExample example);

    SbRolePermissions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SbRolePermissions record, @Param("example") SbRolePermissionsExample example);

    int updateByExample(@Param("record") SbRolePermissions record, @Param("example") SbRolePermissionsExample example);

    int updateByPrimaryKeySelective(SbRolePermissions record);

    int updateByPrimaryKey(SbRolePermissions record);
}