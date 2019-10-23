package com.stopboot.admin.model.test.page;

import com.stopboot.admin.base.vo.BaseVO;
import lombok.Data;


/**
 * @description:  ${model?cap_first} service
 * @author: ${author}
 * @create: ${date?string("yyyy/MM/dd HH:mm")}
 * @version: ${version}
 **/

@Data
public class TestPageVO extends BaseVO {

    /**
     *
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;



}
