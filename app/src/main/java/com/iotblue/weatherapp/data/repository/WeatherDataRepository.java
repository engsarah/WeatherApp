package com.iotblue.weatherapp.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.iotblue.weatherapp.data.domain.entities.WeatherDetailsResponse;
import com.iotblue.weatherapp.data.network.openwheatherapi.OpenWeatherMapService;

public class WeatherDataRepository implements WeatherRepository, GetWeatherDataCallback {


    @Override
    public MutableLiveData<WeatherDetailsResponse> getWeatherDataForLocation(String lat, String lng) {
        return new OpenWeatherMapService().getWeatherDetails(lat, lng, this);
    }

    @Override
    public void onSuccess(WeatherDetailsResponse weatherData) {

    }

    @Override
    public void onError(String error) {

    }
}
