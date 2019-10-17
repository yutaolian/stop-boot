package com.stopboot.admin.base.controller;

import com.stopboot.admin.base.service.DefaultListServiceI;
import com.stopboot.admin.base.params.BasePageParams;


/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-09-24 13:44
 * @version:
 **/

public class DefaultSimpleListController<Service extends DefaultListServiceI, VO, Params extends BasePageParams>
        extends DefaultListController<Service, VO, VO, VO, Params, Params, Params, Params, Params> {


}
