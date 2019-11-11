package com.stopboot.admin.strategy.upload;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-11-08 15:13
 * @description:
 **/

import lombok.Data;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-11-08 15:13
 * @description:
 **/

@Data
public class FileUploadResponse {

    /**
     * 文件全路径
     */
    private String fullUrl;

    /**
     * 文件相对路径
     */
    private String url;
}
