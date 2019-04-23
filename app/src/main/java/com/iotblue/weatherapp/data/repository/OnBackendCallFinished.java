package com.iotblue.weatherapp.data.repository;

import com.iotblue.weatherapp.data.domain.entities.Bookmark;

public interface OnBackendCallFinished {

    void onSuccess(Bookmark bookmark);

    void onError(String error);

}
