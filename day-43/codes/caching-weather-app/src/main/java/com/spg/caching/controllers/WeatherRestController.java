package com.spg.caching.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spg.caching.entites.Weather;
import com.spg.caching.repositories.WeatherRepository;
import com.spg.caching.services.CacheInspectionService;
import com.spg.caching.services.WeatherServices;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/weather")
@AllArgsConstructor
public class WeatherRestController {
	private WeatherServices weatherService;
	private WeatherRepository weatherRepository;

	private CacheInspectionService cacheInspectionService;

	@PostMapping
	public Weather addWeather(@RequestBody Weather weather) {
		return weatherRepository.save(weather);
	}

	@GetMapping
	public String getWeather(@RequestParam String city) {
		String weatherByCity = weatherService.getWeatherByCity(city);
		return weatherByCity;
	}

	@PutMapping("/{city}")
	public String updateWeather(@PathVariable String city, @RequestParam String weatherUpdate) {
		return weatherService.updateWeather(city, weatherUpdate);
	}

    @DeleteMapping("/{city}")
    public String deleteWeather(@PathVariable String city) {
        weatherService.deleteWeather(city);
        return "Weather data for " + city + " has been deleted and cache evicted.";
    }
    
	@GetMapping("/cacheData")
	public void getCacheDate() {
		cacheInspectionService.printCacheContents("weather");
	}

}
