package com.stopboot.admin.controller;

import com.stopboot.admin.common.FailCodeAndMsg;
import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.strategy.upload.FileUploadRequest;
import com.stopboot.admin.strategy.upload.FileUploadResponse;
import com.stopboot.admin.strategy.upload.FileUploadStrategyContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-11-08 15:38
 * @description: 文件上传
 **/

@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    private FileUploadStrategyContext fileUploadStrategyContext;

    /**
     * 上传文件
     *
     * @return
     */
    @PostMapping("upload")
    public ResultData fileLoad(HttpServletRequest request) throws IOException {
        ResultData resultData = ResultData.build();
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartHttpServletRequest.getFile("file");
        FileUploadResponse uploadResponse = fileUploadStrategyContext.execute(new FileUploadRequest(multipartFile.getName(), multipartFile.getInputStream()));
        if (uploadResponse != null) {
            resultData.success(uploadResponse);
        } else {
            resultData.fail().setFailCode(FailCodeAndMsg.FAIL_CODE_FILE_UPLAOD).setFailMsg(FailCodeAndMsg.FAIL_MSG_FILE_UPLAOD);
        }
        return resultData;
    }
}
