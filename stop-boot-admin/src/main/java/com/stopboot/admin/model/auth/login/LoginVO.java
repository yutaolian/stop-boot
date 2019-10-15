package com.stopboot.admin.model.auth.login;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-12 14:51
 * @version:
 **/

@Data
public class LoginVO implements Serializable {

    private Integer id;

    private String name;

    private String token;

    private List<String> roles;

    private List<String> permissions;


}
