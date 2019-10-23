package com.stopboot.admin.base.controller;

import com.stopboot.admin.base.service.DefaultListServiceI;
import com.stopboot.admin.base.params.*;
import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.utils.ClassUtil;
import com.stopboot.admin.utils.SpringContextUtil;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-24 13:44
 * @version:
 **/

public class DefaultListController<Service extends DefaultListServiceI, PageVO, ListVO, OneVO, PageParams extends BasePageParams,
        ListParams extends BaseParams, OneParams extends BaseParams, AddParams extends BaseParams, UpdateParams extends BaseParams, DeleteParams extends BaseParams>
        extends DefaultController<Service, PageVO, OneVO, PageParams, OneParams, AddParams, UpdateParams,DeleteParams> {
    @PostMapping("list")
    public ResultData<ListVO> list(@Validated @RequestBody ListParams params) {
        ResultData resultData = ResultData.build();
        List<ListVO> menuTreeList = service().list(params);
        if (!ObjectUtils.isEmpty(menuTreeList)) {
            resultData.success(menuTreeList);
        } else {
            resultData.empty();
        }
        return resultData;
    }

    private Service service() {
        Class<Service> mapperClass = (Class<Service>) ClassUtil.getClass(getClass(), 0);
        Service service = SpringContextUtil.getBean(mapperClass);
        return service;
    }
}
