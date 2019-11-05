package com.stopboot.admin.model.system.dictionary.list;

import com.stopboot.admin.base.vo.BaseVO;
import lombok.Data;


/**
 * @description:  Dictionary service
 * @author: Lianyutao
 * @create: 2019/11/04 19:54
 * @version: 1.0.1
 **/

@Data
public class DictionaryListVO extends BaseVO {

    /**
    *主键ID
    *
    */
    private Integer id;
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
    *字典值
    *
    */
    private String dicValue;
    /**
    *字典描述
    *
    */
    private String dicDesc;
    /**
    *状态1激活，0冻结
    *
    */
    private Integer status;



}
