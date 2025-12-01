package com.spg.greet.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("WELCOME-SERVICE")
public interface WelcomeFeignClient {
	
	@GetMapping(path = "/welcome")
	public String sendWelcomeMessage();
}
