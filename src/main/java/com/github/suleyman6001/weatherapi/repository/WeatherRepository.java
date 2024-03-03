package com.github.suleyman6001.weatherapi.repository;

import com.github.suleyman6001.weatherapi.entity.CurrentWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<CurrentWeather, Integer> {
    List<Optional<CurrentWeather>> findByLocationName(String location);
}
