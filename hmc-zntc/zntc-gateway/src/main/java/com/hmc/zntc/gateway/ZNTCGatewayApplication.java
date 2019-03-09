package com.hmc.zntc.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZNTCGatewayApplication {

    public static void main(String[] args) {
        System.out.println("----- 智能路由启动中 ... -----");
        SpringApplication.run(ZNTCGatewayApplication.class, args);
        System.out.println("----- 智能路由启动成功 -----");
    }

}
