package com.assignment.spring.dtos;

public class InputDTO {
    private String city;

    public InputDTO(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
}
