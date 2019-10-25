package com.stopboot.admin.controller.system.dictionary;

import com.stopboot.admin.base.controller.DefaultController;
import com.stopboot.admin.model.system.dictionary.add.DictionaryAddParams;
import com.stopboot.admin.model.system.dictionary.one.DictionaryOneParams;
import com.stopboot.admin.model.system.dictionary.one.DictionaryOneVO;
import com.stopboot.admin.model.system.dictionary.page.DictionaryPageParams;
import com.stopboot.admin.model.system.dictionary.page.DictionaryPageVO;
import com.stopboot.admin.model.system.dictionary.update.DictionaryUpdateParams;
import com.stopboot.admin.model.system.dictionary.delete.DictionaryDeleteParams;
import com.stopboot.admin.service.system.dictionary.DictionaryServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/10/25 13:23
 * @version: 1.0.1
 **/

@Slf4j
@RestController
@RequestMapping("/system/dictionary")
public class DictionaryController extends DefaultController<DictionaryServiceI,
                                DictionaryPageVO,DictionaryOneVO,
                                DictionaryPageParams, DictionaryOneParams,
                                DictionaryAddParams, DictionaryUpdateParams, DictionaryDeleteParams> {


}
