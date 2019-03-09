package com.hmc.zntc.order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
//@EnableFeignClients
public class ZNTCOrderApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        System.out.println("----- 订单服务启动中 ... -----");
        SpringApplication.run(ZNTCOrderApplication.class, args);
        System.out.println("----- 订单服务启动成功 -----");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        SpringApplication springApplication = new SpringApplication(ZNTCOrderApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        return application.sources(ZNTCOrderApplication.class);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("")
    public String index() {
        return port;
    }

}
