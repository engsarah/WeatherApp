package com.iotblue.weatherapp.data.network.interceptors;

import com.iotblue.weatherapp.data.network.common.APIConstants;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ReverseGeocodeRequestInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        // Request customization: add request headers

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("key", APIConstants.GOOGLE_REVERSE_GEOCODE_API_KEY).build();

        Request.Builder requestBuilder = original.newBuilder()
                .url(url);

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }

}
