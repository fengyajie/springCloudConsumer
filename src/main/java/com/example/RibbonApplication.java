package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//通过@EnableDiscoveryClient注解来添加发现服务能力
@EnableDiscoveryClient
@SpringBootApplication
public class RibbonApplication {
	
	public static void main(String[] args) {
      SpringApplication.run(RibbonApplication.class, args);
	}

}
