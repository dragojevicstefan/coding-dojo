package com.assignment.spring.service.unit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import com.assignment.spring.api.WeatherResponse;
import com.assignment.spring.dtos.InputDTO;
import com.assignment.spring.mapper.WeatherMapper;
import com.assignment.spring.models.WeatherEntity;
import com.assignment.spring.repository.WeatherRepository;
import com.assignment.spring.service.WeatherService;
import com.assignment.spring.service.impl.WeatherServiceImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class WeatherServiceImplTest {
    
    private String CITY_NAME = "London";
    private String COUNTRY = "GB";

    @Mock
    private RestTemplate restTemplate;
    @Mock
    private WeatherMapper weatherMapper;
    @Mock
    private WeatherRepository weatherRepository;

    @InjectMocks 
    private WeatherServiceImpl weatherService;

    @Test
    public void addWeatherTest() {
        InputDTO input = new InputDTO(CITY_NAME);
        ResponseEntity<WeatherResponse> mockedApiResponse = new ResponseEntity<>(HttpStatus.OK);

        WeatherEntity convertedWeatherEntity = new WeatherEntity();
        WeatherEntity savedWeatherEntity = new WeatherEntity();
        String weatherApiUrl = String.format("null?q=%s&APPID=null", input.getCity());

        when(restTemplate.getForEntity(weatherApiUrl, WeatherResponse.class))
        .thenReturn(mockedApiResponse);
        when(weatherMapper.convert((WeatherResponse) mockedApiResponse.getBody())).thenReturn(convertedWeatherEntity);
        when(weatherRepository.save(convertedWeatherEntity)).thenReturn(savedWeatherEntity);

        WeatherEntity actual = weatherService.addWeather(input);

        assertEquals(savedWeatherEntity, actual);
    }
}
