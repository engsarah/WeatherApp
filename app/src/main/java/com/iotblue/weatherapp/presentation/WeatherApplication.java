package com.iotblue.weatherapp.presentation;

import android.app.Application;

import com.iotblue.weatherapp.presentation.di.component.ApplicationComponent;

public class WeatherApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

//        applicationComponent = DaggerAppComponent
//                .builder()
//                .applicationModule(new ApplicationModule(this))
//                 //.roomModule(new RoomModule(this))
//                .build();

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
