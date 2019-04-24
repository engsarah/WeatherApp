package com.iotblue.weatherapp.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.iotblue.weatherapp.data.domain.entities.WeatherDetailsResponse;

public interface WeatherRepository {

    MutableLiveData<WeatherDetailsResponse> getWeatherDataForLocation(String lat, String lng);
}
