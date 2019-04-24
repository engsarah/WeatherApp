package com.iotblue.weatherapp.data.network.interceptors;

import com.iotblue.weatherapp.data.network.common.APIConstants;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class OpenWeatherMapRequestInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        // Request customization: add request headers

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("appid", APIConstants.OPEN_WEATHER_MAP_API_KEY)
                .addQueryParameter("units", APIConstants.METRIC_FILTER)
                .build();

        Request.Builder requestBuilder = original.newBuilder()
                .url(url);

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }

}
