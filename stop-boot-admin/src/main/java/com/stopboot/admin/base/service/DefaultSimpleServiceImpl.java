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

public class DefaultSimpleServiceImpl<DBMapper, DBRecord, DBExample, VO, Params extends BasePageParams>
        extends DefaultServiceImpl<DBMapper, DBRecord, DBExample, VO, VO, Params, Params, Params, Params, Params>
        implements DefaultSimpleServiceI<VO, Params> {

}
