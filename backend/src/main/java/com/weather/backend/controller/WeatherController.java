package com.weather.backend.controller;

import com.weather.backend.model.WeatherResponse;
import com.weather.backend.service.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class WeatherController {

    private final WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping("/weather")
    public WeatherResponse getWeather(@RequestParam String city) {
        return service.getWeather(city);
    }
}
