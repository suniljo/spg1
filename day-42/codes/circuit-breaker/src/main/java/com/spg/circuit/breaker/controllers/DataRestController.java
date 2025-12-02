package com.spg.circuit.breaker.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class DataRestController {

	@GetMapping(path = "/data")
	@CircuitBreaker(name="dataCircuitBreaker", fallbackMethod = "getDataFromDB")
	public String getDataFromRedis() {		
		System.out.println("*** redis() method called... ***");
		// TODO: Redis conn logic
		int n = 10 / 0; //java.lang.ArithmeticException
		return "fetching from redis";
	}

	public String getDataFromDB(Throwable t) {
		System.out.println("*** db() method called... ***");
		// TODO : db logic
		return "fetching from DB";
	}	
}