package com.example.eurekac1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 启用服务注册发现功能
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaC1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaC1Application.class, args);
	}

}
