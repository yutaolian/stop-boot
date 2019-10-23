package com.stopboot.admin.base.service;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-17 10:26
 * @description:
 **/

import com.stopboot.admin.base.params.BasePageParams;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-17 10:26
 * @description:
 **/

public class DefaultSimpleListServiceImpl<DBMapper, DBRecord, DBExample, PageVO, ListVO, VO, Params extends BasePageParams>
        extends DefaultListServiceImpl<DBMapper, DBRecord, DBExample, PageVO, ListVO, VO, Params, Params, Params, Params, Params, Params>
        implements DefaultSimpleListServiceI<PageVO, ListVO, VO, Params> {

}
