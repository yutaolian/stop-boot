package com.stopboot.admin.model.system.dictionary.update;

import com.stopboot.admin.base.params.BaseUpdateParams;
import lombok.Data;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/11/04 19:54
 * @version: 1.0.1
 **/

@Data
public class DictionaryUpdateParams extends BaseUpdateParams{

    /**
     *字典key
     *
     */
    private String dicKey;
    /**
     * id
     *
     */
    private Integer id;

    /**
     *删除标识（1正常，0删除）
     *
     */
    private Integer deleteFlag;

    /**
     *修改时间
     *
     */
    private java.util.Date updateTime;
}
