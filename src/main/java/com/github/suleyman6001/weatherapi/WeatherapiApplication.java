package com.github.suleyman6001.weatherapi;

import com.github.suleyman6001.weatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherapiApplication {

	@Autowired
	WeatherService weatherService;

	public static void main(String[] args) {
		SpringApplication.run(WeatherapiApplication.class, args);
	}
}
