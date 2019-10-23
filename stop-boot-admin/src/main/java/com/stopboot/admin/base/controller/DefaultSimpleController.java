package com.stopboot.admin.base.controller;

import com.stopboot.admin.base.service.DefaultServiceI;
import com.stopboot.admin.base.params.BasePageParams;


/**
 * @description: 将分页，搜索，新增，等的参数合并
 * @author: Lianyutao
 * @create: 2019-09-24 13:44
 * @version:
 **/

public class DefaultSimpleController<Service extends DefaultServiceI, VO, Params extends BasePageParams>
        extends DefaultController<Service, VO, VO, Params, Params, Params, Params,Params> {


}
