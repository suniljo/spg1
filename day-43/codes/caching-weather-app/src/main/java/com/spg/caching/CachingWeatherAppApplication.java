package com.spg.caching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CachingWeatherAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachingWeatherAppApplication.class, args);
	}

}
