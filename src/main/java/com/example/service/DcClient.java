package com.example.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-client")
public interface DcClient {

	/**
	 * 声明式服务调用客户端
	 * @return
	 */
	@GetMapping("/dc")
	String consumer();
}
