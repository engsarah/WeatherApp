package com.iotblue.weatherapp.data.network.googleapi;

import android.util.Log;

import com.iotblue.weatherapp.data.domain.entities.WeatherDetailsResponse;
import com.iotblue.weatherapp.data.network.common.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OpenWeatherMapService {


    public void getWeatherDetails(String latitude, String longitude) {

        RetrofitClient.getInstance().getGoogleAPI().getWeatherDetails(latitude, longitude).enqueue(new Callback<WeatherDetailsResponse>() {
            @Override
            public void onResponse(Call<WeatherDetailsResponse> call, Response<WeatherDetailsResponse> response) {

                if (response.isSuccessful() && response.body() != null) {

                    Log.d("eee", "eee");
                } else {

                    Log.d("eee", "eee");
                }
            }

            @Override
            public void onFailure(Call<WeatherDetailsResponse> call, Throwable t) {

            }
        });
    }

    public void AddLocationToDB() {

    }

//    private static class addAsyncTask extends AsyncTask<String, Void, Void>{
//
////        private AppDatabase db;
////
////        addAsyncTask(AppDatabase appDatabase){
////            db = appDatabase;
////        }
////
////        @Override
////        protected Void doInBackground(BorrowModel... borrowModels) {
////            db.itemAndPersonModel().addBorrow(borrowModels[0]);
////            return null;
////        }
//    }
}
