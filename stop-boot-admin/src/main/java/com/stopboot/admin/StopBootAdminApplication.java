package com.stopboot.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class StopBootAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(StopBootAdminApplication.class, args);
    }

}
