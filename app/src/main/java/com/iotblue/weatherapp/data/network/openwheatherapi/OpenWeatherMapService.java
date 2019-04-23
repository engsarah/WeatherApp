package com.iotblue.weatherapp.data.network.openwheatherapi;

import com.iotblue.weatherapp.data.domain.entities.Bookmark;
import com.iotblue.weatherapp.data.domain.entities.WeatherDetailsResponse;
import com.iotblue.weatherapp.data.network.common.RetrofitClient;
import com.iotblue.weatherapp.data.repository.OnBackendCallFinished;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OpenWeatherMapService {


    public void getWeatherDetails(String latitude, String longitude, final OnBackendCallFinished onBackendCallFinished) {

        RetrofitClient.getInstance().getGoogleAPI().getWeatherDetails(latitude, longitude).enqueue(new Callback<WeatherDetailsResponse>() {
            @Override
            public void onResponse(Call<WeatherDetailsResponse> call, Response<WeatherDetailsResponse> response) {


                if (response.isSuccessful() && response.body() != null) {
                    WeatherDetailsResponse data = response.body();
                    Bookmark bookmark = new Bookmark();
                    bookmark.setCityName(data.getName());
                    bookmark.setCityId(String.valueOf(data.getId()));
                    bookmark.setCountryCode(String.valueOf(data.getCod()));
                    bookmark.setIcon(data.getWeather().get(0).getIcon());
                    onBackendCallFinished.onSuccess(bookmark);
                } else {

                    onBackendCallFinished.onError("Error while fetching data");

                }
            }

            @Override
            public void onFailure(Call<WeatherDetailsResponse> call, Throwable t) {

            }
        });
    }


}
