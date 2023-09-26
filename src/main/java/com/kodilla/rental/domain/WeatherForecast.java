package com.kodilla.rental.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherForecast {
    @JsonProperty("dt_txt")
    private String date;
    @JsonProperty("weather[0].description")
    private String description;
    @JsonProperty("main.temp")
    private double temperature;
}
