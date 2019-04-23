package com.iotblue.weatherapp.presentation.viewmodels;

import android.app.Application;
import android.location.Location;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.iotblue.weatherapp.data.repository.LocationDataRepository;

public class LocationViewModel extends AndroidViewModel {


    private LocationDataRepository repository;
    private MutableLiveData<Boolean> isLocationAdded;


    public LocationViewModel(@NonNull Application application, LocationDataRepository repository) {
        super(application);
        this.repository = repository;
    }

    public void saveLocation(Location location){

    }


}
