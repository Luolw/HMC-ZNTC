package com.hmc.zntc.charger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@EnableEurekaClient
@SpringBootApplication
@RestController
//@EnableFeignClients
public class ZNTCChargerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        System.out.println("----- 充电服务启动中 ... -----");
        SpringApplication.run(ZNTCChargerApplication.class, args);
        System.out.println("----- 充电服务启动成功 -----");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        SpringApplication springApplication = new SpringApplication(ZNTCChargerApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        return application.sources(ZNTCChargerApplication.class);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("")
    public String index() {
        return port;
    }

}
