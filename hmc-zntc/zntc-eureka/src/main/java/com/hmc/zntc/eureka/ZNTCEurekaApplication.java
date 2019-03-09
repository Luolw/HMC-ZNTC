package com.hmc.zntc.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ZNTCEurekaApplication {

    public static void main(String[] args) {
        System.out.println("----- 注册中心启动中 ... -----");
        SpringApplication.run(ZNTCEurekaApplication.class, args);
        System.out.println("----- 注册中心启动成功 -----");
    }
}
