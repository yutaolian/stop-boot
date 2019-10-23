package com.stopboot.admin.mapper.mybatis;

import com.stopboot.admin.entity.SbDept;
import com.stopboot.admin.entity.SbDeptExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SbDeptMapper {
    int countByExample(SbDeptExample example);

    int deleteByExample(SbDeptExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SbDept record);

    int insertSelective(SbDept record);

    List<SbDept> selectByExample(SbDeptExample example);

    SbDept selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SbDept record, @Param("example") SbDeptExample example);

    int updateByExample(@Param("record") SbDept record, @Param("example") SbDeptExample example);

    int updateByPrimaryKeySelective(SbDept record);

    int updateByPrimaryKey(SbDept record);
}
