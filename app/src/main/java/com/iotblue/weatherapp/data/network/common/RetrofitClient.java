package com.iotblue.weatherapp.data.network.common;

import com.iotblue.weatherapp.data.network.googleapi.OpenWeatherMapAPI;
import com.iotblue.weatherapp.data.network.interceptors.OpenWeatherMapAPIRequestInterceptor;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 * Retrofit factory class responsible for creating retrofit object
 */

public class RetrofitClient {


    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    private RetrofitClient() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .addInterceptor(new OpenWeatherMapAPIRequestInterceptor())
                .addInterceptor(loggingInterceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(APIConstants.OPEN_WEATHER_MAP_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static synchronized RetrofitClient getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public OpenWeatherMapAPI getGoogleAPI() {
        return retrofit.create(OpenWeatherMapAPI.class);
    }
}
