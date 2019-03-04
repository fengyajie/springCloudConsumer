package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.service.ConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="addServiceFallback")
	public String addService() {
		return restTemplate.getForEntity("http://compute-service/add?a=10&b=20", String.class).getBody();
	}
	
	public String addServiceFallback() {
		return "error";
	}

}
