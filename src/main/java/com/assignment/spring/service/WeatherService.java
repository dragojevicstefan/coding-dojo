package com.assignment.spring.service;

import com.assignment.spring.dtos.InputDTO;
import com.assignment.spring.models.WeatherEntity;

import org.springframework.stereotype.Service;

@Service
public interface WeatherService {
    public WeatherEntity addWeather(InputDTO input);
}
