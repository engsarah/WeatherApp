package com.iotblue.weatherapp.data.network.common;

import com.iotblue.weatherapp.data.network.openwheatherapi.OpenWeatherMapAPI;
import com.iotblue.weatherapp.data.network.reversegeocodingapi.GoogleReverseGeocodeAPI;

import okhttp3.Interceptor;
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

    private RetrofitClient(String baseUrl, Interceptor interceptor) {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .addInterceptor(interceptor)
                .addInterceptor(loggingInterceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static synchronized RetrofitClient getInstance(String baseUrl, Interceptor interceptor) {
        if (mInstance == null) {
            mInstance = new RetrofitClient(baseUrl, interceptor);
        }
        return mInstance;
    }

    public OpenWeatherMapAPI getWeatherData() {
        return retrofit.create(OpenWeatherMapAPI.class);
    }

    public GoogleReverseGeocodeAPI getGoogleAPI() {
        return retrofit.create(GoogleReverseGeocodeAPI.class);
    }
}
