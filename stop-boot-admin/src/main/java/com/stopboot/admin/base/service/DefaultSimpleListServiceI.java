package com.stopboot.admin.base.service;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-17 10:25
 * @description: 简化的泛型接口
 **/


import com.stopboot.admin.base.params.BasePageParams;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-17 10:25
 * @description: 简化的泛型接口
 **/

public interface DefaultSimpleListServiceI<PageVO, ListVO, VO, Params extends BasePageParams>
        extends DefaultListServiceI<PageVO, ListVO, VO, Params,Params, Params, Params, Params> {


}
