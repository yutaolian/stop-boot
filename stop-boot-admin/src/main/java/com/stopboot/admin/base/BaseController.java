package com.stopboot.admin.base;

import com.stopboot.admin.common.FailCodeAndMsg;
import com.stopboot.admin.common.PageResult;
import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.utils.ClassUtil;
import com.stopboot.admin.utils.SpringContextUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * @description: 注意：1.子类和父类的PostMapping的value不同时方法名也不能相同
 *                    2.基类默认不提供list方法（不加分页），list方法需自己实现
 * @author: Lianyutao
 * @create: 2019-09-24 13:44
 * @version:
 **/

public abstract class BaseController<Service extends DefaultServiceI, PageVO, OneVO, PageParams extends BasePageParams,
        OneParams extends BaseParams, AddParams extends BaseParams, UpdateParams extends BaseParams> {

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
        if (testPage != null) {
            resultData.success(testPage);
        } else {
            resultData.empty();
        }
        return resultData;
    }

    /**
     * 侧方法只能通过id查找，多条件需在service方法中重写one方法
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
     * @param params
     * @return
     */
    @PutMapping("add")
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
     * 删除 线上通常是逻辑删除
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
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
