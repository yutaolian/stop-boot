package com.stopboot.admin.utils;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-11-08 10:34
 * @description:
 **/

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-11-08 10:34
 * @description:
 **/

public class QiniuFileUploadUtil {

    public static void main(String[] args) {
        QiniuFileUploadUtil.upload();

    }

    public static void upload() {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region1());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = "k-vuY1f0ht_vVy8XFHW9tl24RomgudQI0QGf9k86";
        String secretKey = "T1PczgyxXqtcMg-2pt7dPItlyINOUwrHfMVMnzgg";
        String bucket = "stop-boot";
        //如果是Windows情况下，格式是 D:\\qiniu\\test.png
        String localFilePath = "/Users/91haoke/Desktop/120logo.png";
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = "120logo.png";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (
                QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
    }
}
