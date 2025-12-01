package com.spg.greet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spg.greet.clients.WelcomeFeignClient;

@RestController
public class GreetRestController {
	@Autowired
	private WelcomeFeignClient feignClient;
	
	@Value("${greet.msg}")
	private String greetMsg;
	
	@GetMapping("/greet")
	public String showGreetings() {
		String welcomeMsg = feignClient.sendWelcomeMessage();
		String response = greetMsg + " \n"+welcomeMsg;
		return response;
	}
}
