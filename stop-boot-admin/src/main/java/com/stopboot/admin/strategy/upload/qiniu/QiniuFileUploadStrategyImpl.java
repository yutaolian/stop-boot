package com.stopboot.admin.strategy.upload.qiniu;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.stopboot.admin.config.QiniuConfig;
import com.stopboot.admin.strategy.upload.FileUploadRequest;
import com.stopboot.admin.strategy.upload.FileUploadResponse;
import com.stopboot.admin.strategy.upload.FileUploadStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-11-08 15:09
 * @description:
 **/

@Slf4j
@Service
public class QiniuFileUploadStrategyImpl implements FileUploadStrategy {

    @Resource
    private QiniuConfig config;

    @Override
    public FileUploadResponse upload(FileUploadRequest request) {
        Map data = init();
        try {
            UploadManager uploadManager = (UploadManager) data.get("uploadManager");
            String upToken = (String) data.get("upToken");
            Response response = uploadManager.put(request.getInputStream(), null, upToken, null, null);
            System.out.println(JSON.toJSONString(response));
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
            FileUploadResponse fileUploadResponse = new FileUploadResponse();
            fileUploadResponse.setFullUrl(config.getUrlPrefix() + putRet.key);
            fileUploadResponse.setUrl(putRet.key);
            return fileUploadResponse;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            log.error("upload file error :request:" + JSON.toJSONString(request) + ";error:" + JSON.toJSONString(ex));
        }
        return null;
    }

    private Map init() {
        Map data = new HashMap();
        Region region = null;
        if (config.getRegion().equals("region1")) {
            region = Region.region1();
        }
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(region);
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = config.getAccessKey();
        String secretKey = config.getSecretKey();
        String bucket = config.getBucket();
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        data.put("uploadManager", uploadManager);
        data.put("upToken", upToken);
        return data;
    }

}
