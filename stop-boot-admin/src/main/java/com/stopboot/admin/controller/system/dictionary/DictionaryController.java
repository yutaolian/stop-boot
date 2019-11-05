package com.stopboot.admin.controller.system.dictionary;

import com.stopboot.admin.base.controller.DefaultController;
import com.stopboot.admin.common.FailCodeAndMsg;
import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.model.system.dictionary.add.DictionaryAddParams;
import com.stopboot.admin.model.system.dictionary.list.DictionaryListParams;
import com.stopboot.admin.model.system.dictionary.list.DictionaryListVO;
import com.stopboot.admin.model.system.dictionary.one.DictionaryOneParams;
import com.stopboot.admin.model.system.dictionary.one.DictionaryOneVO;
import com.stopboot.admin.model.system.dictionary.page.DictionaryPageParams;
import com.stopboot.admin.model.system.dictionary.page.DictionaryPageVO;
import com.stopboot.admin.model.system.dictionary.update.DictionaryUpdateParams;
import com.stopboot.admin.model.system.dictionary.delete.DictionaryDeleteParams;
import com.stopboot.admin.service.system.dictionary.DictionaryServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/11/04 19:54
 * @version: 1.0.1
 **/

@Slf4j
@RestController
@RequestMapping("/system/dictionary")
public class DictionaryController extends DefaultController<DictionaryServiceI,
        DictionaryPageVO,DictionaryListVO,DictionaryOneVO,
        DictionaryPageParams, DictionaryListParams,  DictionaryOneParams,
        DictionaryAddParams, DictionaryUpdateParams, DictionaryDeleteParams> {

    @Resource
    private DictionaryServiceI dictionaryService;

    @PostMapping("add")
    @Override
    public ResultData add(DictionaryAddParams params) {
        ResultData resultData = ResultData.build();
        boolean dicKeyFlag = dictionaryService.checkDicKey(params);
        if (dicKeyFlag){
            resultData.fail().setFailCode(FailCodeAndMsg.FAIL_CODE_DIC_KEY_EXIST).setFailMsg(String.format(FailCodeAndMsg.FAIL_MSG_DIC_KEY_EXIST,params.getDicKey()));
        }else{
            boolean flag = dictionaryService.add(params);
            if (flag) {
                resultData.success();
            } else {
                resultData.fail().setFailCode(FailCodeAndMsg.FAIL_CODE_ADD).setFailMsg(FailCodeAndMsg.FAIL_MSG_ADD);
            }
        }
        return resultData;
    }
}
