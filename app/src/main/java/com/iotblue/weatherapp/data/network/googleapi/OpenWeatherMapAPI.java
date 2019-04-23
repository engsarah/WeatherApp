package com.iotblue.weatherapp.data.network.googleapi;


import com.iotblue.weatherapp.data.domain.entities.WeatherDetailsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
 * This class is the retrofit interface to the backend APIs
 */

public interface OpenWeatherMapAPI {


    @GET("data/2.5/weather")
    Call<WeatherDetailsResponse> getWeatherDetails(@Query("lat") String lat, @Query("lon") String lon);
}
