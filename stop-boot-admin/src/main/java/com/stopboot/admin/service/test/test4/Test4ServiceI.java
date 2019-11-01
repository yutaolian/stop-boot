package com.stopboot.admin.service.test.test4;

import com.stopboot.admin.base.service.DefaultServiceI;
import com.stopboot.admin.model.test.test4.add.Test4AddParams;
import com.stopboot.admin.model.test.test4.list.Test4ListVO;
import com.stopboot.admin.model.test.test4.list.Test4ListParams;
import com.stopboot.admin.model.test.test4.one.Test4OneParams;
import com.stopboot.admin.model.test.test4.one.Test4OneVO;
import com.stopboot.admin.model.test.test4.page.Test4PageParams;
import com.stopboot.admin.model.test.test4.page.Test4PageVO;
import com.stopboot.admin.model.test.test4.update.Test4UpdateParams;
import com.stopboot.admin.model.test.test4.delete.Test4DeleteParams;


public interface Test4ServiceI extends DefaultServiceI<Test4PageVO, Test4ListVO, Test4OneVO,
        Test4PageParams, Test4ListParams, Test4OneParams,
        Test4AddParams, Test4UpdateParams, Test4DeleteParams> {

}
