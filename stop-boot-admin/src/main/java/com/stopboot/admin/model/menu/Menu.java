package com.stopboot.admin.model.menu;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-08-14 20:07
 * @version:
 **/
@Data
public class Menu implements Serializable {

    private Integer id;

    private Integer pId;

    private String code;

    private String name;

    private String url;

    private List<Menu> subMenus ;

}
