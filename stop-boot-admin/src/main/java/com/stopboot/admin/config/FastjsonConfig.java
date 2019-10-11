/*
 * Copyright (c) 2016,gaosiedu.com
 */
package com.stopboot.admin.config;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lianyutao
 * @version 3.0.0
 * @description
 * @date 2018/8/6 17:37
 */
@EnableWebMvc
@Configuration
public class FastjsonConfig extends WebMvcConfigurerAdapter {

    /**
     * 修改自定义消息转化器
     *
     * @param converters 消息转换器列表
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //创建fastJson消息转换器
        FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
        //创建配置类
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //过滤并修改配置返回内容 ,保留null属性
        fastJsonConfig.setSerializeFilters((PropertyFilter) (o, s, o1) -> {
            if (o1 == null) {
                return false;
            }
            return true;
        });
        //格式化金钱格式
        fastJsonConfig.setSerializeFilters((ValueFilter) (o, s, source) -> {
            if (null != source && source instanceof BigDecimal) {
                DecimalFormat decimalFormat = new DecimalFormat("###.##");
                BigDecimal bigDecimal = (BigDecimal) source;
                String value = decimalFormat.format(bigDecimal);
                return value;
            }
            return source;
        });
        //时间格式统一处理
        //由于时间格式可能多种，暂不统一处理
//        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        //处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<MediaType>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastJsonConverter.setSupportedMediaTypes(fastMediaTypes);
        fastJsonConverter.setFastJsonConfig(fastJsonConfig);
        //取消对象引用
        // fastJsonConverter.setFeatures(SerializerFeature.DisableCircularReferenceDetect);
        //将fastjson添加到视图消息转换器列表内
        converters.add(fastJsonConverter);
        //解决fastjson  com.alibaba.fastjson.JSONException: autoType is not support
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
    }


}
