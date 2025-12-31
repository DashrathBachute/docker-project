package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class TestController {
	
	
	Logger logger = LoggerFactory.getLogger(TestController.class);

	@GetMapping("/getData")
	public String getData() {
		
		int i = 10;
		logger.info("Data is is found : {}",i);
		return "Data is return";
	}
}
