package com.iotblue.weatherapp.data.repository;

import com.iotblue.weatherapp.data.domain.entities.Bookmark;

public interface ReverseGeocodeCallback {

    void onSuccess(Bookmark bookmark);

    void onError(String error);

}
