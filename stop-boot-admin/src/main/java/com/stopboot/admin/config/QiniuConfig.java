package com.stopboot.admin.config;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-11-08 10:51
 * @description:
 **/

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-11-08 10:51
 * @description:
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "qiniu.default")
public class QiniuConfig {

    /**
     * region
     */
    private String region;

    /**
     * accessKey
     */
    private String accessKey;

    /**
     * secretKey
     */
    private String secretKey;
    /**
     * bucket
     */
    private String bucket;

    /**
     * urlPrefix
     */
    private String urlPrefix;


}
