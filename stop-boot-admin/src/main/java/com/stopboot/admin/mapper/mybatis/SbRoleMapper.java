package com.stopboot.admin.mapper.mybatis;

import com.stopboot.admin.entity.SbRole;
import com.stopboot.admin.entity.SbRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SbRoleMapper {
    int countByExample(SbRoleExample example);

    int deleteByExample(SbRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SbRole record);

    int insertSelective(SbRole record);

    List<SbRole> selectByExample(SbRoleExample example);

    SbRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SbRole record, @Param("example") SbRoleExample example);

    int updateByExample(@Param("record") SbRole record, @Param("example") SbRoleExample example);

    int updateByPrimaryKeySelective(SbRole record);

    int updateByPrimaryKey(SbRole record);
}
