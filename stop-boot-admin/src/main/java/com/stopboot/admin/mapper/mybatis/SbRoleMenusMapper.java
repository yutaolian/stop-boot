package com.stopboot.admin.mapper.mybatis;

import com.stopboot.admin.entity.SbRoleMenus;
import com.stopboot.admin.entity.SbRoleMenusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SbRoleMenusMapper {
    int countByExample(SbRoleMenusExample example);

    int deleteByExample(SbRoleMenusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SbRoleMenus record);

    int insertSelective(SbRoleMenus record);

    List<SbRoleMenus> selectByExample(SbRoleMenusExample example);

    SbRoleMenus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SbRoleMenus record, @Param("example") SbRoleMenusExample example);

    int updateByExample(@Param("record") SbRoleMenus record, @Param("example") SbRoleMenusExample example);

    int updateByPrimaryKeySelective(SbRoleMenus record);

    int updateByPrimaryKey(SbRoleMenus record);
}