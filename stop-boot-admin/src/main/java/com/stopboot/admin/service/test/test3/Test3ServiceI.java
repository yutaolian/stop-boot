package com.stopboot.admin.service.test.test3;

import com.stopboot.admin.base.service.DefaultServiceI;
import com.stopboot.admin.model.test.test3.add.Test3AddParams;
import com.stopboot.admin.model.test.test3.list.Test3ListVO;
import com.stopboot.admin.model.test.test3.list.Test3ListParams;
import com.stopboot.admin.model.test.test3.one.Test3OneParams;
import com.stopboot.admin.model.test.test3.one.Test3OneVO;
import com.stopboot.admin.model.test.test3.page.Test3PageParams;
import com.stopboot.admin.model.test.test3.page.Test3PageVO;
import com.stopboot.admin.model.test.test3.update.Test3UpdateParams;
import com.stopboot.admin.model.test.test3.delete.Test3DeleteParams;


public interface Test3ServiceI extends DefaultServiceI<Test3PageVO, Test3ListVO, Test3OneVO,
        Test3PageParams, Test3ListParams, Test3OneParams,
        Test3AddParams, Test3UpdateParams, Test3DeleteParams> {

}
