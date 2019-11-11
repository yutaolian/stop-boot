package com.stopboot.admin.strategy.upload;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-11-08 15:14
 * @description:
 **/

import lombok.Data;

import java.io.File;
import java.io.InputStream;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-11-08 15:14
 * @description:
 **/

@Data
public class FileUploadRequest {

    /**
     * 策略接口
     */
    private FileUploadStrategy fileUploadStrategy;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件
     */
    private File file;

    /**
     * 流
     */
    private InputStream inputStream;


    /**
     * 文件上传
     * @param fileName
     * @param file
     */
    public FileUploadRequest(String fileName, File file) {
        this.fileName = fileName;
        this.file = file;
    }

    /**
     * 流上传
     * @param fileName
     * @param inputStream
     */
    public FileUploadRequest(String fileName, InputStream inputStream) {
        this.fileName = fileName;
        this.inputStream = inputStream;
    }

    /**
     * 指定策略文件上传
     * @param fileUploadStrategy
     * @param fileName
     * @param file
     */
    public FileUploadRequest(FileUploadStrategy fileUploadStrategy, String fileName, File file) {
        this.fileUploadStrategy = fileUploadStrategy;
        this.fileName = fileName;
        this.file = file;
    }

    /**
     * 指定策略流上传
     * @param fileUploadStrategy
     * @param fileName
     * @param inputStream
     */
    public FileUploadRequest(FileUploadStrategy fileUploadStrategy, String fileName, InputStream inputStream) {
        this.fileUploadStrategy = fileUploadStrategy;
        this.fileName = fileName;
        this.inputStream = inputStream;
    }
}
