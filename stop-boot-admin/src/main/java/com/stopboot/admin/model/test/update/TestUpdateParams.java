package com.stopboot.admin.model.test.update;

import com.stopboot.admin.base.params.BaseParams;
import com.stopboot.admin.base.params.BaseUpdateParams;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;


/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-10 19:20
 * @version:
 **/

@Data
public class TestUpdateParams extends BaseParams {


    private String name;
}
