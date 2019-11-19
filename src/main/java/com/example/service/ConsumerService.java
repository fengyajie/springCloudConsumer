package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ConsumerService {
	
	@Autowired
	RestTemplate restTemplate;
	
	/**
	 * 调用服务超时或发生异常则执行fallback方法
	 * @return
	 */
	@HystrixCommand(fallbackMethod="fallback")
	public String consumerHyxtrix() {
		return restTemplate.getForObject("http://eureka-client/dc", String.class);
	}
	
	
	public String fallback() {
		return "fallback";
	}

}
