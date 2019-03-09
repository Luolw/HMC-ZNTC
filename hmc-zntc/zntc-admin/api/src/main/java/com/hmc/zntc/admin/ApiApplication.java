package com.hmc.zntc.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
@MapperScan(basePackages = {"com.hmc.zntc.admin.mapper"})
public class ApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		SpringApplication springApplication = new SpringApplication(ApiApplication.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		return application.sources(ApiApplication.class);
//		return application.sources(ApiApplication.class);
	}
}
