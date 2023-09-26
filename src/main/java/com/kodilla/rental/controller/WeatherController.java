package com.kodilla.rental.controller;

import com.kodilla.rental.domain.WeatherData;
import com.kodilla.rental.domain.WeatherForecast;
import com.kodilla.rental.service.WeatherApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v2")
public class WeatherController {
    private final String API_KEY = "f7d3d38c0b3fd78631817d44334b625c";
    private final String API_BASE_URL = "https://api.openweathermap.org/data/2.5/forecast";
    List<WeatherForecast> weatherForecasts = new ArrayList<>();
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/weather")
    public ResponseEntity<List<WeatherForecast>> getWeatherForecast(@RequestParam String city) {
        String apiUrl = API_BASE_URL + "?q=" + city + "&units=metric&cnt=7&appid=" + API_KEY;

        ResponseEntity<WeatherApiResponse> responseEntity = restTemplate.getForEntity(apiUrl, WeatherApiResponse.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            WeatherApiResponse weatherApiResponse = responseEntity.getBody();
            List<WeatherForecast> weatherForecasts = new ArrayList<>();

            if (weatherApiResponse != null && weatherApiResponse.getList() != null) {
                for (WeatherData weatherData : weatherApiResponse.getList()) {
                    WeatherForecast forecast = new WeatherForecast(
                            weatherData.getDtTxt(),
                            weatherData.getWeather().get(0).getDescription(),
                            weatherData.getMain().getTemp()
                    );
                    weatherForecasts.add(forecast);
                }

                return new ResponseEntity<>(weatherForecasts, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
