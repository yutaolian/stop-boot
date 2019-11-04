package com.stopboot.admin.model.system.dictionary.add;

import com.stopboot.admin.base.params.BaseAddParams;
import lombok.Data;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/11/04 19:54
 * @version: 1.0.1
 **/

@Data
public class DictionaryAddParams extends BaseAddParams{
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
    /**
     *删除标识（1正常，0删除）
     *
     */
    private Integer deleteFlag;
    /**
     *创建时间
     *
     */
    private java.util.Date createTime;
    /**
     *修改时间
     *
     */
    private java.util.Date updateTime;
}
