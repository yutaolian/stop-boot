package com.stopboot.admin.model.system.dictionary.page;

import com.stopboot.admin.base.vo.BaseVO;
import lombok.Data;


/**
 * @description:  Dictionary service
 * @author: Lianyutao
 * @create: 2019/11/04 19:54
 * @version: 1.0.1
 **/

@Data
public class DictionaryPageVO extends BaseVO {

    /**
    *字典名称
    *
    */
    private String dicName;
    /**
    *字典key
    *
    */
    private String dicKey;
    /**
    *状态1激活，0冻结
    *
    */
    private Integer status;




}
