package com.assignment.spring.service.impl;

import com.assignment.spring.api.WeatherResponse;
import com.assignment.spring.dtos.InputDTO;
import com.assignment.spring.mapper.WeatherMapper;
import com.assignment.spring.models.WeatherEntity;
import com.assignment.spring.repository.WeatherRepository;
import com.assignment.spring.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherServiceImpl implements WeatherService{

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private WeatherMapper weatherMapper;

    @Value("${clientconfig.url}")
    private String url;

    @Value("${clientconfig.appid}")
    private String appid;

    private static final String webService = "OPEN_WEATHER_API";

    @Autowired
    public RestTemplate restTemplate;

    @Override
    public WeatherEntity addWeather(InputDTO input) {
        // TODO Auto-generated method stub

        ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(url.replace("{city}",input.getCity()).replace("{appid}",appid), WeatherResponse.class);

        WeatherEntity weatherEntity = weatherMapper.convert(response.getBody());
        System.out.println(weatherEntity.getId());
        weatherRepository.save(weatherEntity);
        return weatherEntity;
    }
    
}
