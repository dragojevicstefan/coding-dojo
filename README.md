Spring Boot Coding Dojo
---

Welcome to the Spring Boot Coding Dojo!

### Introduction

This is a simple application that requests its data from [OpenWeather](https://openweathermap.org/) and stores the result in a database. 

### Technologies

Java version 11
Java spring boot version 2.1.6.RELEASE
Postgres version 42.2.5
Mockito
Junit

### Instalation

$ cd ../coding-dojo
$ mvn clean install
$ mvn spring-boot:run

### How to use application

To use the application open any browser with the following address:

http://127.0.0.1:8080/api/weather?city={CITY_NAME}

Replace the {CITY_NAME} by the city that you want to know the temperature.

An example of the response:

{
    "id": 792680,
    "city": "Belgrade",
    "country": "RS",
    "temperature": 294.95
}



