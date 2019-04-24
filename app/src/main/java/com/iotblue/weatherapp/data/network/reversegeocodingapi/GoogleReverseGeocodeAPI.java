package com.iotblue.weatherapp.data.network.reversegeocodingapi;


import com.iotblue.weatherapp.data.domain.entities.ReverseGeocodingResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
 * This class is the retrofit interface to the backend APIs
 */

public interface GoogleReverseGeocodeAPI {

    @GET("geocode/json")
    Call<ReverseGeocodingResponse> getLocationAddress(@Query("latlng") String latlng);


}
