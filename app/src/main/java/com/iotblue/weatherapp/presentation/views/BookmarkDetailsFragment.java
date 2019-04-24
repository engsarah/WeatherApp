package com.iotblue.weatherapp.presentation.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.iotblue.weatherapp.R;
import com.iotblue.weatherapp.data.domain.entities.Bookmark;
import com.iotblue.weatherapp.data.domain.entities.WeatherDetailsResponse;
import com.iotblue.weatherapp.presentation.viewmodels.SharedViewModel;
import com.iotblue.weatherapp.presentation.viewmodels.WeatherDataViewModel;

public class BookmarkDetailsFragment extends Fragment {

    private WeatherDataViewModel mViewModel;
    private SharedViewModel sharedViewModel;
    private String lat = "";
    private String lng = "";

    public static BookmarkDetailsFragment newInstance() {
        return new BookmarkDetailsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.weather_forecast_fragment, container, false);
        //lat = getArguments().getString("lat");
        //lng = getArguments().getString("lng");
        return view;
    }

    public void initUIElements() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sharedViewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        mViewModel = ViewModelProviders.of(this).get(WeatherDataViewModel.class);

        sharedViewModel.getSelected().observe(this, new Observer<Bookmark>() {
            @Override
            public void onChanged(Bookmark bookmark) {
                lat = String.valueOf(bookmark.getLat());
                lng = String.valueOf(bookmark.getLng());
            }
        });

        mViewModel.getWeatherDataForLocation(lat, lng).observe(this, new Observer<WeatherDetailsResponse>() {
            @Override
            public void onChanged(WeatherDetailsResponse weatherDetailsResponse) {

                //populate UI Data
            }
        });

    }

}
