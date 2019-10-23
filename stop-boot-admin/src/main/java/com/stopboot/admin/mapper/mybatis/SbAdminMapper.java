package com.stopboot.admin.mapper.mybatis;

import com.stopboot.admin.entity.SbAdmin;
import com.stopboot.admin.entity.SbAdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SbAdminMapper {
    int countByExample(SbAdminExample example);

    int deleteByExample(SbAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SbAdmin record);

    int insertSelective(SbAdmin record);

    List<SbAdmin> selectByExample(SbAdminExample example);

    SbAdmin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SbAdmin record, @Param("example") SbAdminExample example);

    int updateByExample(@Param("record") SbAdmin record, @Param("example") SbAdminExample example);

    int updateByPrimaryKeySelective(SbAdmin record);

    int updateByPrimaryKey(SbAdmin record);
}
