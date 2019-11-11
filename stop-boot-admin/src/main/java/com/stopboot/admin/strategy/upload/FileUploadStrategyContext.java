package com.stopboot.admin.strategy.upload;

import com.stopboot.admin.strategy.upload.qiniu.QiniuFileUploadStrategyImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-11-08 15:16
 * @description:
 **/

@Service
public class FileUploadStrategyContext {


    @Resource
    private QiniuFileUploadStrategyImpl qiniuFileUploadStrategy;

    /**
     * executeUpload
     */
    public FileUploadResponse execute(FileUploadRequest request) {
        FileUploadStrategy defaultStrategy = request.getFileUploadStrategy();
        if (defaultStrategy == null) {
            defaultStrategy = qiniuFileUploadStrategy;
        }
        return defaultStrategy.upload(request);
    }
}
