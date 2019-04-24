package com.iotblue.weatherapp.data.repository;

import com.iotblue.weatherapp.data.domain.entities.WeatherDetailsResponse;

public interface GetWeatherDataCallback {

    void onSuccess(WeatherDetailsResponse weatherData);

    void onError(String error);

}
