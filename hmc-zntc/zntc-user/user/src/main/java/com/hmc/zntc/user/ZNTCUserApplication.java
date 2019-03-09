package com.hmc.zntc.user;

import com.hmc.zntc.user.service.CarService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient // 开启客户端
@SpringBootApplication
@RestController
@EnableFeignClients
@RefreshScope // 开启重新读取配置，重新读取配置接口：/actuator/bus-refresh (post请求)
@MapperScan(basePackages = {"com.hmc.zntc.user.mapper"})
public class ZNTCUserApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        System.out.println("----- 用户服务启动中 ... -----");
        SpringApplication.run(ZNTCUserApplication.class, args);
        System.out.println("----- 用户服务启动成功 -----");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        SpringApplication springApplication = new SpringApplication(ZNTCUserApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        return application.sources(ZNTCUserApplication.class);
    }

    @Value("${foo}")
    String port;

    @Autowired
    CarService carService;

    @RequestMapping("")
    public String index() {
        return port;
    }


    @RequestMapping("/car")
    public String car() {
        return carService.car();
    }
}
