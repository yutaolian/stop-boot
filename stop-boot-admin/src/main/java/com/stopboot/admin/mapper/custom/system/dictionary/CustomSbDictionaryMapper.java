package com.stopboot.admin.mapper.custom.system.dictionary;

import com.stopboot.admin.entity.SbDictionary;
import com.stopboot.admin.entity.SbDictionaryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomSbDictionaryMapper {

    List<SbDictionary> selectByExample(SbDictionaryExample example);

}
