package com.example.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {
    @GET("weather?appid=b73cb095796150ef6cb1caf7772e995d&units=metric")
    Call<OpenWeatherMap> getWeatherWithLocation(@Query("lat") double lat, @Query("lon") double lon);

    @GET("weather?appid=b73cb095796150ef6cb1caf7772e995d&units=metric")
    Call<OpenWeatherMap> getWeatherWithCity(@Query("q") String name);
}
