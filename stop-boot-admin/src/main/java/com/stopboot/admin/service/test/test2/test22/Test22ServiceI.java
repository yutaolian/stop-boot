package com.stopboot.admin.service.test.test2.test22;

import com.stopboot.admin.base.service.DefaultServiceI;
import com.stopboot.admin.model.test.test2.test22.add.Test22AddParams;
import com.stopboot.admin.model.test.test2.test22.list.Test22ListVO;
import com.stopboot.admin.model.test.test2.test22.list.Test22ListParams;
import com.stopboot.admin.model.test.test2.test22.one.Test22OneParams;
import com.stopboot.admin.model.test.test2.test22.one.Test22OneVO;
import com.stopboot.admin.model.test.test2.test22.page.Test22PageParams;
import com.stopboot.admin.model.test.test2.test22.page.Test22PageVO;
import com.stopboot.admin.model.test.test2.test22.update.Test22UpdateParams;
import com.stopboot.admin.model.test.test2.test22.delete.Test22DeleteParams;


public interface Test22ServiceI extends DefaultServiceI<Test22PageVO, Test22ListVO, Test22OneVO,
        Test22PageParams, Test22ListParams, Test22OneParams,
        Test22AddParams, Test22UpdateParams, Test22DeleteParams> {

}
