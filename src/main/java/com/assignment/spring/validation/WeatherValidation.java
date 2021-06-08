package com.assignment.spring.validation;


import com.assignment.spring.api.WeatherResponse;
import com.assignment.spring.dtos.InputDTO;

public interface WeatherValidation {
    boolean isValidWeatherInput(InputDTO input);
    boolean isValidWeatherResponse(WeatherResponse response);
}
