package com.spg.caching.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spg.caching.entites.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

	Optional<Weather> findByCity(String city);

	void deleteByCity(String city);

}
