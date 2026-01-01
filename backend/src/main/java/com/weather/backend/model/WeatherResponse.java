package com.weather.backend.model;

import lombok.Data;

@Data
public class WeatherResponse {
    private String name;
    private Main main;
    private Wind wind;
    private String source;

    @Data
    public static class Main {
        private double temp;
        private double feels_like;
        private int humidity;
    }

    @Data
    public static class Wind {
        private double speed;
    }
}
