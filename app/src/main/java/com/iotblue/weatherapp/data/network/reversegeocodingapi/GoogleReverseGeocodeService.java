package com.iotblue.weatherapp.data.network.reversegeocodingapi;

import com.iotblue.weatherapp.data.domain.entities.Bookmark;
import com.iotblue.weatherapp.data.domain.entities.ReverseGeocodingResponse;
import com.iotblue.weatherapp.data.network.common.APIConstants;
import com.iotblue.weatherapp.data.network.common.RetrofitClient;
import com.iotblue.weatherapp.data.network.interceptors.ReverseGeocodeRequestInterceptor;
import com.iotblue.weatherapp.data.repository.ReverseGeocodeCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GoogleReverseGeocodeService {


    public void getLocationAddress(String latlng, final ReverseGeocodeCallback reverseGeocodeCallback) {

        RetrofitClient.getInstance(APIConstants.GOOGLE_REVERSE_GEOCODE_BASE_URL, new ReverseGeocodeRequestInterceptor()).getGoogleAPI().getLocationAddress(latlng).enqueue(new Callback<ReverseGeocodingResponse>() {
            @Override
            public void onResponse(Call<ReverseGeocodingResponse> call, Response<ReverseGeocodingResponse> response) {

                if (response.isSuccessful() && response.body() != null) {
                    ReverseGeocodingResponse data = response.body();
                    if (data.getResults().size() != 0) {
                        Bookmark bookmark = data.getResults().get(0).getGeometry().getBookmark();
                        bookmark.setAddress(data.getResults().get(0).getFormattedAddress());
                        reverseGeocodeCallback.onSuccess(bookmark);
                    } else {
                        reverseGeocodeCallback.onError("Error while fetching data");
                    }


                } else {

                    reverseGeocodeCallback.onError("Error while fetching data");

                }
            }

            @Override
            public void onFailure(Call<ReverseGeocodingResponse> call, Throwable t) {

            }
        });

    }


}
