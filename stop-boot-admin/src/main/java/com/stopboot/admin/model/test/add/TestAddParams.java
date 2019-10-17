package com.stopboot.admin.model.test.add;

import com.stopboot.admin.base.params.BaseParams;
import lombok.Data;



/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-10 19:36
 * @version:
 **/

@Data
public class TestAddParams extends BaseParams {

    /**
     * 姓名
     */
    private String name;
}
