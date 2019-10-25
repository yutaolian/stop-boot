package com.stopboot.admin.service.system.dictionary;

import com.stopboot.admin.mapper.mybatis.SbTestMapper;
import com.stopboot.admin.entity.SbTest;
import com.stopboot.admin.entity.SbTestExample;
import com.stopboot.admin.base.service.DefaultServiceImpl;
import com.stopboot.admin.model.system.dictionary.add.DictionaryAddParams;
import com.stopboot.admin.model.system.dictionary.one.DictionaryOneParams;
import com.stopboot.admin.model.system.dictionary.one.DictionaryOneVO;
import com.stopboot.admin.model.system.dictionary.page.DictionaryPageParams;
import com.stopboot.admin.model.system.dictionary.page.DictionaryPageVO;
import com.stopboot.admin.model.system.dictionary.update.DictionaryUpdateParams;
import com.stopboot.admin.model.system.dictionary.delete.DictionaryDeleteParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @description:  Dictionary service
 * @author: Lianyutao
 * @create: 2019/10/25 13:23
 * @version: 1.0.1
**/

@Slf4j
@Service
public class DictionaryServiceImpl extends DefaultServiceImpl<SbTestMapper, SbTest, SbTestExample,
                                DictionaryPageVO, DictionaryOneVO,
                                DictionaryPageParams, DictionaryOneParams,
                                DictionaryAddParams, DictionaryUpdateParams, DictionaryDeleteParams>
                                implements DictionaryServiceI {



}
