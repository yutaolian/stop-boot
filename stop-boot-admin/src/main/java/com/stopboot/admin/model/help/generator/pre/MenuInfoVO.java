package com.stopboot.admin.model.help.generator.pre;/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-23 15:48
 * @description:
 **/

import com.stopboot.admin.dto.MenuInfo;
import lombok.Data;

import java.io.Serializable;

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-10-23 15:48
 * @description:
 **/
@Data
public class MenuInfoVO implements Serializable {

    private Integer id;
    private Integer pid;
    private String path;
    private String component;
    private String name;
    private String title;
    private String fullPath;

}
