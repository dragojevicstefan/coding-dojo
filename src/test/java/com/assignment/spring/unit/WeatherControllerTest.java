package com.assignment.spring.service.unit;

import com.assignment.spring.Application;
import com.assignment.spring.controller.WeatherController;
import com.assignment.spring.service.impl.WeatherServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = WeatherController.class)
@ContextConfiguration(classes = {Application.class})
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class WeatherControllerTest {


    @MockBean
    private WeatherServiceImpl weatherService;

    
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() throws Exception{

    }

    @Test
    public void when_missing_city_query_param_then_returns_400() throws Exception {
        this.mockMvc.perform(get("/weather?")).andExpect(status().isBadRequest());
    }
    @Test
    public void when_not_missing_city_query_param_then_returns_200() throws Exception {
        mockMvc.perform(get("/weather?city=Sabac"))
                .andExpect(status().isOk());
    }


}
