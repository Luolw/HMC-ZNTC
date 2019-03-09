package com.hmc.zntc.car;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient // 开启客户端
@SpringBootApplication
@RestController
public class ZNTCCarApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        System.out.println("----- 车位服务启动中 ... -----");
        SpringApplication.run(ZNTCCarApplication.class, args);
        System.out.println("----- 车位服务启动成功 -----");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        SpringApplication springApplication = new SpringApplication(ZNTCCarApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        return application.sources(ZNTCCarApplication.class);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/user")
    public String user() {
        return port;
    }

    @RequestMapping("/car")
    public String car() {
        return "car success";
    }
}
