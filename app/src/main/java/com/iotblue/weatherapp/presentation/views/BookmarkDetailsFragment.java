package com.iotblue.weatherapp.presentation.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

    TextView cityTxtvw, tempTxtvw, humidityTxtvw, rainTxtvw, cloudsTxtvw, windTxtvw;
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
        View view = inflater.inflate(R.layout.weather_details_fragment, container, false);
        initUIElements(view);
        return view;
    }

    public void initUIElements(View rootView) {

        cityTxtvw = rootView.findViewById(R.id.city_name_txtvw);
        tempTxtvw = rootView.findViewById(R.id.temp_txtvw);
        humidityTxtvw = rootView.findViewById(R.id.humidity_value_txtvw);
        windTxtvw = rootView.findViewById(R.id.wind_value_txtvw);
        rainTxtvw = rootView.findViewById(R.id.rain_value_txtvw);
        cloudsTxtvw = rootView.findViewById(R.id.cloud_value_txtvw);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(WeatherDataViewModel.class);
        sharedViewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        sharedViewModel.getSelected().observe(getViewLifecycleOwner(), new Observer<Bookmark>() {
            @Override
            public void onChanged(Bookmark bookmark) {
                lat = String.valueOf(bookmark.getLat());
                lng = String.valueOf(bookmark.getLng());
                mViewModel.getWeatherDataForLocation(lat, lng).observe(getViewLifecycleOwner(), new Observer<WeatherDetailsResponse>() {
                    @Override
                    public void onChanged(WeatherDetailsResponse weatherDetailsResponse) {

                        if (weatherDetailsResponse.getName() != null && !weatherDetailsResponse.getName().equals("")) {
                            cityTxtvw.setText(weatherDetailsResponse.getName());
                        }
                        tempTxtvw.setText(weatherDetailsResponse.getMain().getTemp() + "°C");
                        humidityTxtvw.setText(weatherDetailsResponse.getMain().getHumidity() + "%");
                        windTxtvw.setText(weatherDetailsResponse.getWind().getSpeed() + " meters/s");
                        cloudsTxtvw.setText(weatherDetailsResponse.getClouds().getAll() + "%");
                        if (weatherDetailsResponse.getRain().getRainLast3Hour() != null && !weatherDetailsResponse.getRain().getRainLast3Hour().equals("")) {
                            rainTxtvw.setText(weatherDetailsResponse.getRain().getRainLast3Hour());
                        } else {
                            rainTxtvw.setText("No rain");
                        }



                    }
                });

            }
        });


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
