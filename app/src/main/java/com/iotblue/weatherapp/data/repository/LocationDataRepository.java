package com.iotblue.weatherapp.data.repository;

import com.iotblue.weatherapp.data.network.googleapi.OpenWeatherMapService;

public class LocationDataRepository {

    private boolean isAvailableInDB = false;

    public void addLocationInDB() {
        //Check if location already exists in DB
        new OpenWeatherMapService().getWeatherDetails("-33.852", "151.211");
    }



}
