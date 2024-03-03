package com.github.suleyman6001.weatherapi.controller;

import com.github.suleyman6001.weatherapi.entity.CurrentWeather;
import com.github.suleyman6001.weatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherDataController {

    @Autowired
    WeatherService weatherService;

    /**
     * This method sends the weather report of the requested location back to the frontend
     * @param location the location of the weather report
     * @return weather report for the given location
     */
    @GetMapping("/weatherapi/getWeather/{location}")
    public CurrentWeather sendCurrentWeather(@PathVariable String location) {
        return weatherService.getWeatherReport(location);
    }

}
