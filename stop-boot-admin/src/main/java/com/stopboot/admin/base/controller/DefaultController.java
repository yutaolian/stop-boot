package com.stopboot.admin.base.controller;

import com.stopboot.admin.base.params.*;
import com.stopboot.admin.base.service.DefaultServiceI;
import com.stopboot.admin.common.FailCodeAndMsg;
import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.strategy.upload.FileUploadRequest;
import com.stopboot.admin.strategy.upload.FileUploadResponse;
import com.stopboot.admin.strategy.upload.FileUploadStrategyContext;
import com.stopboot.admin.utils.ClassUtil;
import com.stopboot.admin.utils.SpringContextUtil;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;


/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-24 13:44
 * @version:
 **/

public class DefaultController<Service extends DefaultServiceI, PageVO, ListVO, OneVO,
        PageParams extends BasePageParams, ListParams extends BaseParams, OneParams extends BaseParams, AddParams extends BaseParams, UpdateParams extends BaseParams, DeleteParams extends BaseParams> {


    /**
     * 此分页默认不加条件，如条件分页需在service 中重写page方法
     *
     * @param params
     * @return
     */
    @PostMapping("page")
    public ResultData<PageVO> page(@Validated @RequestBody PageParams params) {
        ResultData resultData = ResultData.build();
        PageResult<PageVO> testPage = service().page(params);
        resultData.success(testPage);
        return resultData;
    }


    /**
     * 分会列表，默认实现为空
     *
     * @param params
     * @return
     */
    @PostMapping("list")
    public ResultData<ListVO> list(@Validated @RequestBody ListParams params) {
        ResultData resultData = ResultData.build();
        List<ListVO> menuTreeList = service().list(params);
        resultData.success(menuTreeList);
        return resultData;
    }

    /**
     * 侧方法只能通过id查找，多条件需在service方法中重写one方法
     *
     * @param params
     * @return
     */
    @PostMapping("one")
    public ResultData<OneVO> one(@Validated @RequestBody OneParams params) {
        ResultData resultData = ResultData.build();
        OneVO one = (OneVO) service().one(params);
        if (one != null) {
            resultData.success(one);
        } else {
            resultData.empty();
        }
        return resultData;
    }

    /**
     * 更新
     *
     * @param params
     * @return
     */
    @PostMapping("update")
    public ResultData update(@Validated @RequestBody UpdateParams params) {
        ResultData resultData = ResultData.build();
        boolean flag = service().update(params);
        if (flag) {
            resultData.success();
        } else {
            resultData.fail().setFailCode(FailCodeAndMsg.FAIL_CODE_UPDATE).setFailMsg(FailCodeAndMsg.FAIL_MSG_UPDATE);
        }
        return resultData;
    }

    /**
     * 添加
     *
     * @param params
     * @return
     */
    @PostMapping("add")
    public ResultData add(@Validated @RequestBody AddParams params) {
        ResultData resultData = ResultData.build();
        boolean flag = service().add(params);
        if (flag) {
            resultData.success();
        } else {
            resultData.fail().setFailCode(FailCodeAndMsg.FAIL_CODE_ADD).setFailMsg(FailCodeAndMsg.FAIL_MSG_ADD);
        }
        return resultData;
    }

    /**
     * 删除 线上通常是逻辑删除 需自行定义逻辑删除接口
     *
     * @param deleteParams
     * @return
     */
    @PostMapping("delete")
    public ResultData delete(@Validated @RequestBody DeleteParams deleteParams) {
        ResultData resultData = ResultData.build();
        boolean flag = service().delete(deleteParams);
        if (flag) {
            resultData.success();
        } else {
            resultData.fail().setFailCode(FailCodeAndMsg.FAIL_CODE_DELETE).setFailMsg(FailCodeAndMsg.FAIL_MSG_DELETE);
        }
        return resultData;
    }


    /**
     * 删除 线上通常是逻辑删除 需自行定义逻辑删除接口
     *
     * @param id
     * @return
     */
    @PostMapping("delete/{id}")
    public ResultData delete(@PathVariable Integer id) {
        ResultData resultData = ResultData.build();
        boolean flag = service().delete(id);
        if (flag) {
            resultData.success();
        } else {
            resultData.fail().setFailCode(FailCodeAndMsg.FAIL_CODE_DELETE).setFailMsg(FailCodeAndMsg.FAIL_MSG_DELETE);
        }
        return resultData;
    }


    private Service service() {
        Class<Service> mapperClass = (Class<Service>) ClassUtil.getClass(getClass(), 0);
        Service service = SpringContextUtil.getBean(mapperClass);
        return service;
    }
}
