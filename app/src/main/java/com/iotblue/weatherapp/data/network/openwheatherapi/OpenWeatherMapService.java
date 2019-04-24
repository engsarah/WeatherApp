package com.iotblue.weatherapp.data.network.openwheatherapi;

import androidx.lifecycle.MutableLiveData;

import com.iotblue.weatherapp.data.domain.entities.WeatherDetailsResponse;
import com.iotblue.weatherapp.data.network.common.APIConstants;
import com.iotblue.weatherapp.data.network.common.RetrofitClient;
import com.iotblue.weatherapp.data.network.interceptors.OpenWeatherMapRequestInterceptor;
import com.iotblue.weatherapp.data.repository.GetWeatherDataCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OpenWeatherMapService {


    public MutableLiveData<WeatherDetailsResponse> getWeatherDetails(String latitude, String longitude, final GetWeatherDataCallback getWeatherDataCallback) {

        final MutableLiveData<WeatherDetailsResponse> weatherDetailsResponse = new MutableLiveData<>();
        RetrofitClient.getInstance(APIConstants.OPEN_WEATHER_MAP_BASE_URL, new OpenWeatherMapRequestInterceptor()).getWeatherData().getWeatherDetails(latitude, longitude).enqueue(new Callback<WeatherDetailsResponse>() {
            @Override
            public void onResponse(Call<WeatherDetailsResponse> call, Response<WeatherDetailsResponse> response) {


                if (response.isSuccessful() && response.body() != null) {
                    WeatherDetailsResponse data = response.body();
                    weatherDetailsResponse.postValue(data);

                } else {

                    getWeatherDataCallback.onError("Error while fetching data");

                }
            }

            @Override
            public void onFailure(Call<WeatherDetailsResponse> call, Throwable t) {

            }
        });
        return weatherDetailsResponse;
    }


}
