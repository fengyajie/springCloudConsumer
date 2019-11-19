package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.service.ConsumerService;
import com.example.service.DcClient;


@RestController
public class DcController {
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	@Autowired
	DcClient dcClient;
	
	@Autowired
	ConsumerService consumerService;
	
	//ribbon-consumer
	/**
	 * 手工调用
	 * @return
	 */
	@GetMapping("/consumer")
	public String consumer() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
		String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/dc";
		System.out.println("url:"+url);
		return restTemplate.getForObject(url, String.class);
	}
	
	/**
	 * 自动负载均衡调用服务
	 * @return
	 */
	@GetMapping("/consumerRibbon")
	public String consumerRibbon() {
		//Spring Cloud Ribbon有一个拦截器，它能够在这里进行实际调用的时候，自动的去选取服务实例，并将实际要请求的IP地址和端口替换这里的服务名，从而完成服务接口的调用。
		//return restTemplate.getForObject("http://eureka-client/dc", String.class);
		return consumerService.consumerHyxtrix();
	}
	
	/**
	 * 声明式服务调用客户端
	 * @return
	 */
	@GetMapping("/consumerFeign")
	public String consumerFeign() {
		return dcClient.consumer();
	}

}
