package com.stopboot.admin.base.vo;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-28 19:05
 * @description:
 **/

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-28 19:05
 * @description:
 **/

@Data
public class BaseMenuTreeVO implements Serializable {

    private Integer id;

    private Integer pid;

    private List<BaseMenuTreeVO> children;
}
