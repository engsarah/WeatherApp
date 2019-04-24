package com.iotblue.weatherapp.presentation.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.iotblue.weatherapp.R;

public class BookmarkDetailsFragment extends Fragment {

    //private WeatherForecastViewModel mViewModel;

    public static BookmarkDetailsFragment newInstance() {
        return new BookmarkDetailsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.weather_forecast_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mViewModel = ViewModelProviders.of(this).get(WeatherForecastViewModel.class);
        // TODO: Use the ViewModel
    }

}
