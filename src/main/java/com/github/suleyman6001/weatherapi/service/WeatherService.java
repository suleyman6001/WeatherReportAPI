package com.github.suleyman6001.weatherapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.suleyman6001.weatherapi.entity.CurrentWeather;
import com.github.suleyman6001.weatherapi.repository.WeatherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class WeatherService {
    @Value("${weatherapi.apikey}")
    private String apiKey;
    private WebClient webClient;
    private WeatherRepository weatherRepository;
    Logger logger = LoggerFactory.getLogger(WeatherService.class);

    @Autowired
    public WeatherService(WebClient webClient, WeatherRepository weatherRepository) {
        this.webClient = webClient;
        this.weatherRepository = weatherRepository;
    }

    /**
     * This method gets the weather report of the given location from the external weather api, saves it in DB
     * and returns it
     * @param location the location of the requested weather report
     * @return weather report for the given location
     */
    public CurrentWeather getWeatherReport(String location) {
        String uri = "?key=" + apiKey + "&aqi=yes" + "&q=";
        String jsonResponse = webClient.get().uri(uri + location).retrieve().bodyToMono(String.class).block();
        CurrentWeather currentWeather = unpackJson(jsonResponse);
        weatherRepository.save(currentWeather);
        logger.info("Saved the weather forecast: " + currentWeather);
        return currentWeather;
    }

    /**
     * This method retrieves weather reports for given location from the DB
     * @param location the location of the requested weather report
     * @return weather reports for the given location
     */
    public List<CurrentWeather> findWeatherReport(String location) {
        List<Optional<CurrentWeather>> currentWeatherList = weatherRepository.findByLocationName(location);
        return currentWeatherList.stream().filter(currentWeather1 -> currentWeather1.isPresent())
                .map(curElement -> curElement.get()).toList();
    }

    /**
     * This method processes the received external API JSON and sets the currentWeather object with correct values
     * @param json weather report JSON received from the external API
     * @return weather report for the given location
     */
    private CurrentWeather unpackJson(String json) {
        CurrentWeather currentWeather = new CurrentWeather();
        ObjectMapper mapper = new ObjectMapper();
        String location = "location";
        String current = "current";
        String airQuality = "air_quality";

        JsonNode currentWeatherNode;
        try {
            currentWeatherNode = mapper.readTree(json);
            // Setting location fields
            currentWeather.setCreationDate(Timestamp.from(Instant.now()));
            currentWeather.setLocationName(currentWeatherNode.get(location).get("name").textValue());
            currentWeather.setRegion(currentWeatherNode.get(location).get("region").textValue());
            currentWeather.setCountry(currentWeatherNode.get(location).get("country").textValue());
            currentWeather.setLatitude(currentWeatherNode.get(location).get("lat").doubleValue());
            currentWeather.setLongitude(currentWeatherNode.get(location).get("lon").doubleValue());
            currentWeather.setTimezoneId(currentWeatherNode.get(location).get("tz_id").textValue());
            currentWeather.setLocaltime(currentWeatherNode.get(location).get("localtime").textValue());

            currentWeather.setLastUpdated(currentWeatherNode.get(current).get("last_updated").textValue());
            currentWeather.setTempInCelcius(currentWeatherNode.get(current).get("temp_c").doubleValue());
            currentWeather.setTempInFahrenheit(currentWeatherNode.get(current).get("temp_f").doubleValue());
            currentWeather.setConditionText(currentWeatherNode.get(current).get("condition").get("text").textValue());
            currentWeather.setWindSpeedMph(currentWeatherNode.get(current).get("wind_mph").doubleValue());
            currentWeather.setWindSpeedKph(currentWeatherNode.get(current).get("wind_kph").doubleValue());
            currentWeather.setWindDegree(currentWeatherNode.get(current).get("wind_degree").intValue());
            currentWeather.setWindDirection(currentWeatherNode.get(current).get("wind_dir").textValue());
            currentWeather.setPressureMillibars(currentWeatherNode.get(current).get("pressure_mb").doubleValue());
            currentWeather.setPressureInches(currentWeatherNode.get(current).get("pressure_in").doubleValue());
            currentWeather.setPrecipitationMillimeters(currentWeatherNode.get(current).get("precip_mm").doubleValue());
            currentWeather.setPrecipitationInches(currentWeatherNode.get(current).get("precip_in").doubleValue());
            currentWeather.setHumidityPercentage(currentWeatherNode.get(current).get("humidity").intValue());
            currentWeather.setCloudPercentage(currentWeatherNode.get(current).get("cloud").intValue());
            currentWeather.setFeelsLikeCelcius(currentWeatherNode.get(current).get("feelslike_c").doubleValue());
            currentWeather.setFeelsLikeFahrenheit(currentWeatherNode.get(current).get("feelslike_f").doubleValue());
            currentWeather.setVisibilityKilometer(currentWeatherNode.get(current).get("vis_km").doubleValue());
            currentWeather.setVisibilityMiles(currentWeatherNode.get(current).get("vis_miles").doubleValue());
            currentWeather.setUvIndex(currentWeatherNode.get(current).get("uv").doubleValue());
            currentWeather.setVisibilityMiles(currentWeatherNode.get(current).get("vis_miles").doubleValue());
            currentWeather.setWindGustMph(currentWeatherNode.get(current).get("gust_mph").doubleValue());
            currentWeather.setWindGustKph(currentWeatherNode.get(current).get("gust_kph").doubleValue());

            // Air quality index fields
            currentWeather.setCarbonMonoxideAmount(currentWeatherNode.get(current).get(airQuality).get("co").doubleValue());
            currentWeather.setNitrogenDioxideAmount(currentWeatherNode.get(current).get(airQuality).get("no2").doubleValue());
            currentWeather.setOzoneAmount(currentWeatherNode.get(current).get(airQuality).get("o3").doubleValue());
            currentWeather.setSulphurDioxideAmount(currentWeatherNode.get(current).get(airQuality).get("so2").doubleValue());
            currentWeather.setPm2_5Amount(currentWeatherNode.get(current).get(airQuality).get("pm2_5").doubleValue());
            currentWeather.setPm10Amount(currentWeatherNode.get(current).get(airQuality).get("pm10").doubleValue());
            currentWeather.setUsEpaIndex(currentWeatherNode.get(current).get(airQuality).get("us-epa-index").intValue());
            currentWeather.setGbEpaIndex(currentWeatherNode.get(current).get(airQuality).get("gb-defra-index").intValue());
        }
        catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return currentWeather;
    }
}