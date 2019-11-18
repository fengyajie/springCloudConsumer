package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DcController {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/dc")
	public void dc() {
		List<String> servicesList = discoveryClient.getServices();
		for(String service:servicesList) {
			System.out.println("service:"+servicesList);
		}
	}

}
