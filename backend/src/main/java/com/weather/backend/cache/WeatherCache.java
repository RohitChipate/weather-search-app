package com.weather.backend.cache;

import com.weather.backend.model.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class WeatherCache {

    private static class CacheEntry {
        WeatherResponse data;
        long expiryTime;

        CacheEntry(WeatherResponse data, long expiryTime) {
            this.data = data;
            this.expiryTime = expiryTime;
        }
    }

    private final Map<String, CacheEntry> cache = new ConcurrentHashMap<>();
    private final long TTL = 10 * 60 * 1000; // 10 minutes
    private final int MAX_SIZE = 100;

    public WeatherResponse get(String city) {
        CacheEntry entry = cache.get(city.toLowerCase());

        if (entry == null)
            return null;

        if (System.currentTimeMillis() > entry.expiryTime) {
            cache.remove(city.toLowerCase());
            return null;
        }

        return entry.data;
    }

    public void put(String city, WeatherResponse data) {

        if (cache.size() >= MAX_SIZE) {
            cache.clear(); // simple eviction
        }

        cache.put(
                city.toLowerCase(),
                new CacheEntry(data, System.currentTimeMillis() + TTL));
    }
}
