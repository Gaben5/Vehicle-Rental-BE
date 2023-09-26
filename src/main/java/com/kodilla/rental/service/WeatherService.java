package com.kodilla.rental.service;

import com.kodilla.rental.domain.Currencies;
import com.kodilla.rental.domain.WeatherForecast;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class WeatherService {
    RestTemplate restTemplate = new RestTemplate();
    String API_KEY = "f7d3d38c0b3fd78631817d44334b625c";
    String API_BASE_URL = "https://api.openweathermap.org/data/2.5/forecast";


    public List<WeatherForecast> getWeatherForecasts(String city){

        Object[] result = restTemplate.getForObject(API_BASE_URL + "?city=" + city + "&units=metric&cnt=7&appid=" +API_KEY, Object[].class);
        List<WeatherForecast> weatherForecastList = null;
        List<Object> list = Arrays.asList(Objects.requireNonNull(result));

        weatherForecastList.add(new WeatherForecast("2023-09-20", "Rain", 20.5));
        return weatherForecastList;
    }
}
