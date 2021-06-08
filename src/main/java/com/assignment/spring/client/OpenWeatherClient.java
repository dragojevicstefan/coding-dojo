package com.assignment.spring.client;

import com.assignment.spring.api.WeatherResponse;
import com.assignment.spring.exception.InternalServerErrorException;
import com.assignment.spring.exception.NotFoundErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenWeatherClient {

    @Value("${clientconfig.url}")
    private String url;

    @Value("${clientconfig.appid}")
    private String appid;

    private static final String webService = "OPEN_WEATHER_API";

    @Autowired
    public RestTemplate restTemplate;
    
    public WeatherResponse getWeatherData(String city){
        ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(url+"?q="+city+"&APPID="+appid, WeatherResponse.class);

        if(response.getStatusCode().is5xxServerError()){
            throw new InternalServerErrorException( webService, response.getStatusCode(), "Server error");
        }
        if(response.getStatusCode().is4xxClientError()){
            throw new NotFoundErrorException( webService, response.getStatusCode(), "Client error");
        }
        return response.getBody();
    }
}
