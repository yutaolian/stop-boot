package com.stopboot.admin.model.help.generator.submit;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-16 16:40
 * @version:
 **/

@Data
public class GeneratorSubmitVO implements Serializable {

    /**
     * 下载地址
     */
    private String url;

}
