package com.hmc.zntc.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer // config 配置服务
@EnableEurekaClient
public class ZNTCConfigApplication {

	public static void main(String[] args) {
		System.out.println("----- 配置中心启动中 ... -----");
		SpringApplication.run(ZNTCConfigApplication.class, args);
		System.out.println("----- 配置中心启动成功 -----");
	}
}
