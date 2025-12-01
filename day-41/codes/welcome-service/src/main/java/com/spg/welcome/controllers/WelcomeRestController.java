package com.spg.welcome.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	@Autowired
	private Environment env;
	
	@GetMapping(path = "/welcome")
	public String sendWelcomeMessage() {
		String port = env.getProperty("server.port"); 
		String responseText = "Welcome to S&P Globals application working in port ("+port+")";
		return responseText;
	}
}
