package com.iotblue.weatherapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.iotblue.weatherapp.presentation.adapters.ViewPagerAdapter;
import com.iotblue.weatherapp.presentation.views.BookmarksFragment;
import com.iotblue.weatherapp.presentation.views.MapFragment;
import com.iotblue.weatherapp.presentation.views.WeatherForecastFragment;

public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MapFragment(), "ONE");
        adapter.addFragment(new BookmarksFragment(), "TWO");
        adapter.addFragment(new WeatherForecastFragment(), "THREE");
        viewPager.setAdapter(adapter);
    }

    private void initToolbar() {

    }
}