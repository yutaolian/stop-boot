/*
 * Copyright (c) 2016,gaosiedu.com
 */
package com.stopboot.admin.utils;


import com.stopboot.admin.common.PageResult;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lianyutao
 * @describe
 * @date 2017/7/27 14:34
 * @since 2.1.0
 */
public class BeansHelper<FROM, TO> {

    /**
     * 使用volatile关键字保其可见性
     */
    private volatile static BeansHelper instance = null;

    private BeansHelper() {
    }

    //懒汉式
    public static BeansHelper getInstance() {
        try {
            if (instance != null) {
            } else {
                //创建实例之前可能会有一些准备性的耗时工作
                synchronized (BeansHelper.class) {
                    //二次检查
                    if (instance == null) {
                        instance = new BeansHelper();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

    /**
     * 属性拷贝方法，有特殊需求时子类覆写此方法
     */
    private void copyProperties(FROM from, TO to) throws Exception {
        BeanUtils.copyProperties(from, to);
    }

    /**
     * 单个对象转换
     */
    public TO convert(FROM from, Class<TO> clazz) {
        if (from == null) {
            return null;
        }
        TO to = null;
        try {
            to = clazz.newInstance();
            copyProperties(from, to);
        } catch (Exception e) {
            throw new RuntimeException("class convert error");
        }
        return to;
    }

    /**
     * 批量对象转换
     */
    public List<TO> convert(List<FROM> fromList, Class<TO> clazz) {
        if (fromList == null || fromList.isEmpty()) {
            return new ArrayList<>();
        }
        List<TO> toList = new ArrayList<>();
        for (FROM from : fromList) {
            toList.add(convert(from, clazz));
        }
        return toList;
    }

    /**
     * 批量对象转换
     */
    public PageResult<TO> convert(PageResult<FROM> fromPage, Class<TO> clazz) {
        List<TO> toList = this.convert(fromPage.getList(), clazz);
        PageResult<TO> toPageResult = new PageResult<>();
        toPageResult.copyInfo(fromPage);
        toPageResult.setList(toList);
        return toPageResult;
    }
}
