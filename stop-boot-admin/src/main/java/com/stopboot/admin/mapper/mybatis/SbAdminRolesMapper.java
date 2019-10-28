package com.stopboot.admin.mapper.mybatis;

import com.stopboot.admin.entity.SbAdminRoles;
import com.stopboot.admin.entity.SbAdminRolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SbAdminRolesMapper {
    int countByExample(SbAdminRolesExample example);

    int deleteByExample(SbAdminRolesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SbAdminRoles record);

    int insertSelective(SbAdminRoles record);

    List<SbAdminRoles> selectByExample(SbAdminRolesExample example);

    SbAdminRoles selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SbAdminRoles record, @Param("example") SbAdminRolesExample example);

    int updateByExample(@Param("record") SbAdminRoles record, @Param("example") SbAdminRolesExample example);

    int updateByPrimaryKeySelective(SbAdminRoles record);

    int updateByPrimaryKey(SbAdminRoles record);
}