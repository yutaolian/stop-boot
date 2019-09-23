package com.stopboot.admin.dao.mybatis.mapper;

import com.stopboot.admin.entity.SbRole;
import com.stopboot.admin.entity.SbRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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