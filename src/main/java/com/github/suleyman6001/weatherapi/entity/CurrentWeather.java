package com.github.suleyman6001.weatherapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "current_weather")
public class CurrentWeather {

    // Location properties
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @JsonIgnore
    @Column(name = "creation_date")
    private Timestamp creationDate;

    @Column(name = "location_name")
    private String locationName;

    @Column(name = "region")
    private String region;

    @Column(name = "country")
    private String country;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "timezoneId")
    private String timezoneId;

    @Column(name = "timeInLocation")
    private String timeInLocation;

    @Column(name = "last_updated")
    private String lastUpdated;

    @Column(name = "temp_in_celcius")
    private double tempInCelcius;

    @Column(name = "temp_in_fahrenheit")
    private double tempInFahrenheit;

    @Column(name = "condition_text")
    private String conditionText;

    @Column(name = "wind_speed_mph")
    private double windSpeedMph;

    @Column(name = "wind_speed_kph")
    private double windSpeedKph;

    @Column(name = "wind_degree")
    private Integer windDegree;

    @Column(name = "wind_direction")
    private String windDirection;

    @Column(name = "pressure_millibars")
    private double pressureMillibars;

    @Column(name = "pressure_inches")
    private double pressureInches;

    @Column(name = "precipitation_millimeters")
    private double precipitationMillimeters;

    @Column(name = "precipitation_inches")
    private double precipitationInches;

    @Column(name = "humidity_percentage")
    private int humidityPercentage;

    @Column(name = "cloud_percentage")
    private int cloudPercentage;

    @Column(name = "feels_like_celcius")
    private double feelsLikeCelcius;

    @Column(name = "feels_like_fahrenheit")
    private double feelsLikeFahrenheit;

    @Column(name = "visibility_kilometer")
    private double visibilityKilometer;

    @Column(name = "visibility_miles")
    private double visibilityMiles;

    @Column(name = "uv_index")
    private double uvIndex;

    @Column(name = "wind_gust_mph")
    private double windGustMph;

    @Column(name = "wind_gust_kph")
    private double windGustKph;

    // Air quality properties
    @Column(name = "carbon_monoxide_amount")
    private double carbonMonoxideAmount;

    @Column(name = "nitrogen_dioxide_amount")
    private double nitrogenDioxideAmount;

    @Column(name = "ozone_amount")
    private double ozoneAmount;

    @Column(name = "sulphur_dioxide_amount")
    private double sulphurDioxideAmount;

    @Column(name = "pm2_5_amount")
    private double pm2_5Amount;

    @Column(name = "pm10_amount")
    private double pm10Amount;

    @Column(name = "us_epa_index")
    private int usEpaIndex;

    @Column(name = "gb_epa_index")
    private int gbEpaIndex;

    public CurrentWeather() {
    }

    public CurrentWeather(String lastUpdated, double tempInCelcius, double tempInFahrenheit, String conditionText, double windSpeedMph, double windSpeedKph, Integer windDegree, String windDirection, double pressureMillibars, double pressureInches,
                          double precipitationMillimeters, double precipitationInches, int humidityPercentage, int cloudPercentage, double feelsLikeCelcius, double feelsLikeFahrenheit, double visibilityKilometer, double visibilityMiles,
                          double uvIndex, double windGustMph, double windGustKph, double carbonMonoxideAmount, double nitrogenDioxideAmount, double ozoneAmount, double sulphurDioxideAmount, double pm2_5Amount, double pm10Amount,
                          int usEpaIndex, int gbEpaIndex, String locationName, String region, String country, Double latitude, Double longitude, String timezoneId, String timeInLocation) {
        this.lastUpdated = lastUpdated;
        this.tempInCelcius = tempInCelcius;
        this.tempInFahrenheit = tempInFahrenheit;
        this.conditionText = conditionText;
        this.windSpeedMph = windSpeedMph;
        this.windSpeedKph = windSpeedKph;
        this.windDegree = windDegree;
        this.windDirection = windDirection;
        this.pressureMillibars = pressureMillibars;
        this.pressureInches = pressureInches;
        this.precipitationMillimeters = precipitationMillimeters;
        this.precipitationInches = precipitationInches;
        this.humidityPercentage = humidityPercentage;
        this.cloudPercentage = cloudPercentage;
        this.feelsLikeCelcius = feelsLikeCelcius;
        this.feelsLikeFahrenheit = feelsLikeFahrenheit;
        this.visibilityKilometer = visibilityKilometer;
        this.visibilityMiles = visibilityMiles;
        this.uvIndex = uvIndex;
        this.windGustMph = windGustMph;
        this.windGustKph = windGustKph;
        this.carbonMonoxideAmount = carbonMonoxideAmount;
        this.nitrogenDioxideAmount = nitrogenDioxideAmount;
        this.ozoneAmount = ozoneAmount;
        this.sulphurDioxideAmount = sulphurDioxideAmount;
        this.pm2_5Amount = pm2_5Amount;
        this.pm10Amount = pm10Amount;
        this.usEpaIndex = usEpaIndex;
        this.gbEpaIndex = gbEpaIndex;
        this.locationName = locationName;
        this.region = region;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timezoneId = timezoneId;
        this.timeInLocation = timeInLocation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public double getTempInCelcius() {
        return tempInCelcius;
    }

    public void setTempInCelcius(double tempInCelcius) {
        this.tempInCelcius = tempInCelcius;
    }

    public double getTempInFahrenheit() {
        return tempInFahrenheit;
    }

    public void setTempInFahrenheit(double tempInFahrenheit) {
        this.tempInFahrenheit = tempInFahrenheit;
    }

    public String getConditionText() {
        return conditionText;
    }

    public void setConditionText(String conditionText) {
        this.conditionText = conditionText;
    }

    public double getWindSpeedMph() {
        return windSpeedMph;
    }

    public void setWindSpeedMph(double windSpeedMph) {
        this.windSpeedMph = windSpeedMph;
    }

    public double getWindSpeedKph() {
        return windSpeedKph;
    }

    public void setWindSpeedKph(double windSpeedKph) {
        this.windSpeedKph = windSpeedKph;
    }

    public Integer getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(Integer windDegree) {
        this.windDegree = windDegree;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public double getPressureMillibars() {
        return pressureMillibars;
    }

    public void setPressureMillibars(double pressureMillibars) {
        this.pressureMillibars = pressureMillibars;
    }

    public double getPressureInches() {
        return pressureInches;
    }

    public void setPressureInches(double pressureInches) {
        this.pressureInches = pressureInches;
    }

    public double getPrecipitationMillimeters() {
        return precipitationMillimeters;
    }

    public void setPrecipitationMillimeters(double precipitationMillimeters) {
        this.precipitationMillimeters = precipitationMillimeters;
    }

    public double getPrecipitationInches() {
        return precipitationInches;
    }

    public void setPrecipitationInches(double precipitationInches) {
        this.precipitationInches = precipitationInches;
    }

    public int getHumidityPercentage() {
        return humidityPercentage;
    }

    public void setHumidityPercentage(int humidityPercentage) {
        this.humidityPercentage = humidityPercentage;
    }

    public int getCloudPercentage() {
        return cloudPercentage;
    }

    public void setCloudPercentage(int cloudPercentage) {
        this.cloudPercentage = cloudPercentage;
    }

    public double getFeelsLikeCelcius() {
        return feelsLikeCelcius;
    }

    public void setFeelsLikeCelcius(double feelsLikeCelcius) {
        this.feelsLikeCelcius = feelsLikeCelcius;
    }

    public double getFeelsLikeFahrenheit() {
        return feelsLikeFahrenheit;
    }

    public void setFeelsLikeFahrenheit(double feelsLikeFahrenheit) {
        this.feelsLikeFahrenheit = feelsLikeFahrenheit;
    }

    public double getVisibilityKilometer() {
        return visibilityKilometer;
    }

    public void setVisibilityKilometer(double visibilityKilometer) {
        this.visibilityKilometer = visibilityKilometer;
    }

    public double getVisibilityMiles() {
        return visibilityMiles;
    }

    public void setVisibilityMiles(double visibilityMiles) {
        this.visibilityMiles = visibilityMiles;
    }

    public double getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(double uvIndex) {
        this.uvIndex = uvIndex;
    }

    public double getWindGustMph() {
        return windGustMph;
    }

    public void setWindGustMph(double windGustMph) {
        this.windGustMph = windGustMph;
    }

    public double getWindGustKph() {
        return windGustKph;
    }

    public void setWindGustKph(double windGustKph) {
        this.windGustKph = windGustKph;
    }

    public double getCarbonMonoxideAmount() {
        return carbonMonoxideAmount;
    }

    public void setCarbonMonoxideAmount(double carbonMonoxideAmount) {
        this.carbonMonoxideAmount = carbonMonoxideAmount;
    }

    public double getNitrogenDioxideAmount() {
        return nitrogenDioxideAmount;
    }

    public void setNitrogenDioxideAmount(double nitrogenDioxideAmount) {
        this.nitrogenDioxideAmount = nitrogenDioxideAmount;
    }

    public double getOzoneAmount() {
        return ozoneAmount;
    }

    public void setOzoneAmount(double ozoneAmount) {
        this.ozoneAmount = ozoneAmount;
    }

    public double getSulphurDioxideAmount() {
        return sulphurDioxideAmount;
    }

    public void setSulphurDioxideAmount(double sulphurDioxideAmount) {
        this.sulphurDioxideAmount = sulphurDioxideAmount;
    }

    public double getPm2_5Amount() {
        return pm2_5Amount;
    }

    public void setPm2_5Amount(double pm2_5Amount) {
        this.pm2_5Amount = pm2_5Amount;
    }

    public double getPm10Amount() {
        return pm10Amount;
    }

    public void setPm10Amount(double pm10Amount) {
        this.pm10Amount = pm10Amount;
    }

    public int getUsEpaIndex() {
        return usEpaIndex;
    }

    public void setUsEpaIndex(int usEpaIndex) {
        this.usEpaIndex = usEpaIndex;
    }

    public int getGbEpaIndex() {
        return gbEpaIndex;
    }

    public void setGbEpaIndex(int gbEpaIndex) {
        this.gbEpaIndex = gbEpaIndex;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTimezoneId() {
        return timezoneId;
    }

    public void setTimezoneId(String timezoneId) {
        this.timezoneId = timezoneId;
    }

    public String getLocaltime() {
        return timeInLocation;
    }

    public void setLocaltime(String timeInLocation) {
        this.timeInLocation = timeInLocation;
    }

    @Override
    public String toString() {
        return "CurrentWeather {" +
                "\n\tid: " + id +
                "\n\tLast Updated: " + lastUpdated +
                "\n\tLocation Info {" +
                "\n\t\tLocation: " + locationName +
                "\n\t\tRegion: " + region +
                "\n\t\tCountry: " + country +
                "\n\t\tLatitude: " + latitude +
                "\n\t\tLongitude: " + longitude +
                "\n\t\tTimezone ID: " + timezoneId +
                "\n\t\tLocaltime: " + timeInLocation +
                "\n\t}\n\tTemp in Celcius: " + tempInCelcius +
                "\n\tTemp in Fahrenheit: " + tempInFahrenheit +
                "\n\tCondition: " + conditionText +
                "\n\tWind speed in MPH: " + windSpeedMph +
                "\n\tWind speed in KPH: " + windSpeedKph +
                "\n\tWind degree: " + windDegree +
                "\n\tWind direction: " + windDirection +
                "\n\tPressure in millibars: " + pressureMillibars +
                "\n\tPressure in inches: " + pressureInches +
                "\n\tPrecipitation in millimeters: " + precipitationMillimeters +
                "\n\tPrecipitation in inches: " + precipitationInches +
                "\n\tHumidity percentage: " + humidityPercentage +
                "\n\tCloud percentage: " + cloudPercentage +
                "\n\tFeels-like temperature in Celcius: " + feelsLikeCelcius +
                "\n\tFeels-like temperature in Fahrenheit: " + feelsLikeFahrenheit +
                "\n\tVisibility in Kilometers: " + visibilityKilometer +
                "\n\tVisibility in Miles: " + visibilityMiles +
                "\n\tUV index: " + uvIndex +
                "\n\tWind gust Mph: " + windGustMph +
                "\n\tWind gust Kph: " + windGustKph +
                "\n\tAir Quality Index {" +
                "\n\t\tCarbon Monoxide amount: " + carbonMonoxideAmount +
                "\n\t\tNitrogen Dioxide amount: " + nitrogenDioxideAmount +
                "\n\t\tOzone amount: " + ozoneAmount +
                "\n\t\tSulphur Dioxide amount: " + sulphurDioxideAmount +
                "\n\t\tpm2_5 amount: " + pm2_5Amount +
                "\n\t\tpm10 amount: " + pm10Amount +
                "\n\t\tusEpaIndex (1 (Best Air Quality) - 6 (Worst Air Quality)): " + usEpaIndex +
                "\n\t\tgbEpaIndex (1 (Best Air Quality) - 10 (Worst Air Quality)): " + gbEpaIndex
                + "\n\t}\n}";
    }
}
