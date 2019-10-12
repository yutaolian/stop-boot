package com.stopboot.admin.model.auth.login;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-12 14:50
 * @version:
 **/

@Data
public class LoginParams implements Serializable {

    @ApiModelProperty("手机号")
    @NotNull
    private String username;

    @ApiModelProperty("手机号")
    @NotNull
    private String mobile;

    @ApiModelProperty("密码")
    @NotNull
    private String password;

}
