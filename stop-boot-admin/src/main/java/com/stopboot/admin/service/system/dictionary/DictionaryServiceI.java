package com.stopboot.admin.service.system.dictionary;

import com.stopboot.admin.base.service.DefaultServiceI;
import com.stopboot.admin.model.system.dictionary.add.DictionaryAddParams;
import com.stopboot.admin.model.system.dictionary.list.DictionaryListVO;
import com.stopboot.admin.model.system.dictionary.list.DictionaryListParams;
import com.stopboot.admin.model.system.dictionary.one.DictionaryOneParams;
import com.stopboot.admin.model.system.dictionary.one.DictionaryOneVO;
import com.stopboot.admin.model.system.dictionary.page.DictionaryPageParams;
import com.stopboot.admin.model.system.dictionary.page.DictionaryPageVO;
import com.stopboot.admin.model.system.dictionary.update.DictionaryUpdateParams;
import com.stopboot.admin.model.system.dictionary.delete.DictionaryDeleteParams;


public interface DictionaryServiceI extends DefaultServiceI<DictionaryPageVO, DictionaryListVO, DictionaryOneVO,
        DictionaryPageParams, DictionaryListParams, DictionaryOneParams,
        DictionaryAddParams, DictionaryUpdateParams, DictionaryDeleteParams> {

}
