package com.hmc.zntc.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient // 开启客户端
@SpringBootApplication
@MapperScan(basePackages = {"com.hmc.zntc.admin.mapper"})
public class ZNTCAdminApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.out.println("----- 后台管理系统服务启动中 ... -----");
		SpringApplication.run(ZNTCAdminApplication.class, args);
		System.out.println("----- 后台管理系统服务启动成功 -----");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		SpringApplication springApplication = new SpringApplication(ZNTCAdminApplication.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		return application.sources(ZNTCAdminApplication.class);
	}
}
