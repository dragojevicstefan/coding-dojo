package com.assignment.spring.validation.impl;


import com.assignment.spring.api.WeatherResponse;
import com.assignment.spring.dtos.InputDTO;
import com.assignment.spring.validation.WeatherValidation;

import org.springframework.stereotype.Component;

@Component
public class WeatherValidationImpl implements WeatherValidation{



	@Override
	public boolean isValidWeatherResponse(WeatherResponse response) {
		// TODO Auto-generated method stub
		try{
			String city=response.getName();
			String country= response.getSys().getCountry();
			Double temperature = response.getMain().getTemp();
			if(!city.isEmpty() && !country.isEmpty() && !temperature.isNaN()){
				return true;
			}

		} 
		catch (Exception e){
			return false;
		}
		return false;
	}

	@Override
	public boolean isValidWeatherInput(InputDTO input) {
		// TODO Auto-generated method stub
		try {
			if (!input.getCity().isEmpty()){
				return true;
			}
		}
		catch (Exception e) {
			return false;
		}
        return false;
	}
    
}
