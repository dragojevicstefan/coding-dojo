package com.assignment.spring.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.assignment.spring.dtos.InputDTO;
import com.assignment.spring.models.WeatherEntity;
import com.assignment.spring.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WeatherController{

    @Autowired
    private WeatherService weatherService;
    

    @GetMapping("/weather")
    public ResponseEntity<WeatherEntity> getWeather(@RequestParam @Valid @NotNull String city) {
       InputDTO inputDTO = new InputDTO(city);
        return new ResponseEntity(this.weatherService.addWeather(inputDTO),HttpStatus.OK);
    }
}
