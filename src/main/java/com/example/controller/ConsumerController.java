package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ConsumerService;

@RestController
public class ConsumerController {

	@Autowired
	private ConsumerService consumerService;
	
	//compute-service区分大小写，与服务提供端配置文件spring.application.name属性值相同
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add() {
		return consumerService.addService();
	}
}
