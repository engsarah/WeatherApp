package com.iotblue.weatherapp.presentation.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.iotblue.weatherapp.data.domain.entities.WeatherDetailsResponse;
import com.iotblue.weatherapp.data.repository.WeatherDataRepository;
import com.iotblue.weatherapp.data.repository.WeatherRepository;

public class WeatherDataViewModel extends AndroidViewModel {


    private MutableLiveData<WeatherDetailsResponse> weatherData;
    private WeatherRepository weatherRepository;

    public WeatherDataViewModel(@NonNull Application application) {
        super(application);
        weatherRepository = new WeatherDataRepository();
    }

    public MutableLiveData<WeatherDetailsResponse> getWeatherDataForLocation(String lat, String lng) {
        return weatherRepository.getWeatherDataForLocation(lat, lng);
    }


}
