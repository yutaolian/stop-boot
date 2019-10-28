package com.stopboot.admin.mapper.mybatis;

import com.stopboot.admin.entity.SbMenuPermissions;
import com.stopboot.admin.entity.SbMenuPermissionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SbMenuPermissionsMapper {
    int countByExample(SbMenuPermissionsExample example);

    int deleteByExample(SbMenuPermissionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SbMenuPermissions record);

    int insertSelective(SbMenuPermissions record);

    List<SbMenuPermissions> selectByExample(SbMenuPermissionsExample example);

    SbMenuPermissions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SbMenuPermissions record, @Param("example") SbMenuPermissionsExample example);

    int updateByExample(@Param("record") SbMenuPermissions record, @Param("example") SbMenuPermissionsExample example);

    int updateByPrimaryKeySelective(SbMenuPermissions record);

    int updateByPrimaryKey(SbMenuPermissions record);
}