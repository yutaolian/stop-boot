package com.stopboot.admin.service.test.test1;

import com.stopboot.admin.base.service.DefaultServiceI;
import com.stopboot.admin.model.test.test1.add.Test1AddParams;
import com.stopboot.admin.model.test.test1.list.Test1ListVO;
import com.stopboot.admin.model.test.test1.list.Test1ListParams;
import com.stopboot.admin.model.test.test1.one.Test1OneParams;
import com.stopboot.admin.model.test.test1.one.Test1OneVO;
import com.stopboot.admin.model.test.test1.page.Test1PageParams;
import com.stopboot.admin.model.test.test1.page.Test1PageVO;
import com.stopboot.admin.model.test.test1.update.Test1UpdateParams;
import com.stopboot.admin.model.test.test1.delete.Test1DeleteParams;


public interface Test1ServiceI extends DefaultServiceI<Test1PageVO, Test1ListVO, Test1OneVO,
        Test1PageParams, Test1ListParams, Test1OneParams,
        Test1AddParams, Test1UpdateParams, Test1DeleteParams> {

}
