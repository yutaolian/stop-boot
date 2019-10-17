package com.stopboot.admin.jwt;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-12 18:00
 * @version:
 **/

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) {
        String pass = new BCryptPasswordEncoder().encode("pass");
        if (!StringUtils.isEmpty(username) && username.contains("user")) {
            return new JwtUser("123123", username, pass, "USER", true);
        } else {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }
    }
}
