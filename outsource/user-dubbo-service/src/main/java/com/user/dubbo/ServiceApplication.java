package com.user.dubbo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.user.dubbo.mapper")
public class ServiceApplication {
    public static void main(String args[]){
        SpringApplication.run(ServiceApplication.class,args);
    }
}
