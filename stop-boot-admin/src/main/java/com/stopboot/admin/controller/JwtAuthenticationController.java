package com.stopboot.admin.controller;

import com.stopboot.admin.common.FailCodeAndMsg;
import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.exception.BizException;
import com.stopboot.admin.jwt.JwtTokenUtil;
import com.stopboot.admin.jwt.JwtUser;
import com.stopboot.admin.jwt.JwtUserDetailsService;
import com.stopboot.admin.model.auth.login.LoginParams;
import com.stopboot.admin.model.auth.login.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-12 18:05
 * @version:
 **/

@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Value("${jwt.header}")
    private String tokenHeader;

    @PostMapping("${jwt.authentication.path}")
    public ResultData<?> createAuthenticationToken(@RequestBody LoginParams authenticationRequest) {
        ResultData build = ResultData.build();
        System.out.println("username:" + authenticationRequest.getUsername() + ",password:" + authenticationRequest.getPassword());
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        LoginVO loginVO = new LoginVO();
        loginVO.setName(userDetails.getUsername());
        loginVO.setToken(token);
        return build.success(loginVO);
    }

    private void authenticate(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new BizException(FailCodeAndMsg.FAIL_CODE_USER_DISABLE, FailCodeAndMsg.FAIL_MSG_USER_DISABLE);
        } catch (BadCredentialsException e) {
            throw new BizException(FailCodeAndMsg.FAIL_CODE_LOGIN, FailCodeAndMsg.FAIL_MSG_LOGIN);
        } catch (UsernameNotFoundException e) {
            throw new BizException(FailCodeAndMsg.FAIL_CODE_USER_NO_EXIST, FailCodeAndMsg.FAIL_MSG_USER_NO_EXIST);
        }
    }

    @GetMapping("/token")
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;
    }

}
