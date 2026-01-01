package com.weather.backend.service;

import com.weather.backend.cache.WeatherCache;
import com.weather.backend.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    private final WeatherCache cache;
    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherService(WeatherCache cache) {
        this.cache = cache;
    }

    public WeatherResponse getWeather(String city) {

        WeatherResponse cached = cache.get(city);
        if (cached != null) {
            cached.setSource("CACHE");
            return cached;
        }

        String url = apiUrl + "?q=" + city + "&appid=" + apiKey + "&units=metric";

        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);

        response.setSource("API");
        cache.put(city, response);
        return response;
    }
}
