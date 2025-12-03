package com.spg.caching.services;

import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spg.caching.entites.Weather;
import com.spg.caching.repositories.WeatherRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherServices {

	private final WeatherRepository weatherRepo;
	
	@Cacheable(value = "weather",key = "#city")
	public String getWeatherByCity(String city) {
		System.out.println("Fetching data from DB for city: " + city);
		Optional<Weather> weather = weatherRepo.findByCity(city);
		return weather.map(Weather::getForecast).orElse("Weather data not available for city: " + city);
	}	
	
	@CachePut(value = "weather",key = "#city")
	public String updateWeather(String city, String updatedWeather) {
		weatherRepo.findByCity(city).ifPresent(weather -> {
			weather.setForecast(updatedWeather);
			weatherRepo.save(weather);
		});
		return updatedWeather;
	}

	@Transactional
	@CacheEvict(value = "weather",key = "#city")
	public void deleteWeather(String city) {
		System.out.println("Removing weather data for city: " + city);
		weatherRepo.deleteByCity(city);
	}	
}
