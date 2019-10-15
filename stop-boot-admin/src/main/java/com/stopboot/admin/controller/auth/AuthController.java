package com.stopboot.admin.controller.auth;

import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.model.auth.login.LoginParams;
import com.stopboot.admin.model.auth.login.LoginVO;
import com.stopboot.admin.service.auth.login.LoginServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 认证入口
 * @author: Lianyutao
 * @create: 2019-10-12 14:48
 * @version:
 **/
@Slf4j
@RestController
@RequestMapping("auth")
@Api(value = "验证模块")
public class AuthController  {

    @Resource
    private LoginServiceI loginService;

    @ApiOperation(value = "登录", notes = "根据参数添加用户")
    @PostMapping("login")
    public ResultData<LoginVO> login(@Validated @RequestBody LoginParams params) {
        ResultData resultData = ResultData.build();
        LoginVO loginVO = loginService.login(params);
        if (loginVO != null) {
            resultData.success(loginVO);
        } else {
            resultData.empty();
        }
        return resultData;
    }
}
