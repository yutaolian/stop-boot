package com.stopboot.admin.strategy.upload;


/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-11-08 13:58
 * @description:
 **/

public interface FileUploadStrategy {

    /**
     * 文件上传
     * @param request
     * @return
     */
    FileUploadResponse upload(FileUploadRequest request);

}
