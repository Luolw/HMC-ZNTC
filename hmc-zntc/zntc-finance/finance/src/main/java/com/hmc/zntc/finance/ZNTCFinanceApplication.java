package com.hmc.zntc.finance;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
//@EnableFeignClients
public class ZNTCFinanceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        System.out.println("----- 财务服务启动中 ... -----");
        SpringApplication.run(ZNTCFinanceApplication.class, args);
        System.out.println("----- 财务服务启动成功 -----");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        SpringApplication springApplication = new SpringApplication(ZNTCFinanceApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        return application.sources(ZNTCFinanceApplication.class);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("")
    public String index() {
        return port;
    }

}
