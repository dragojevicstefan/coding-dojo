package com.assignment.spring.mapper;

import com.assignment.spring.api.WeatherResponse;
import com.assignment.spring.models.WeatherEntity;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapper implements Converter<WeatherResponse, WeatherEntity>{

    @Override
    public WeatherEntity convert(WeatherResponse weatherResponse) {
        // TODO Auto-generated method stub
        WeatherEntity entity = new WeatherEntity();
        entity.setId(weatherResponse.getId());
        entity.setCity(weatherResponse.getName());
        entity.setCountry(weatherResponse.getSys().getCountry());
        entity.setTemperature(weatherResponse.getMain().getTemp());
        return entity;
    }
    
}
