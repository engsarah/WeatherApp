package com.iotblue.weatherapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.iotblue.weatherapp.presentation.adapters.ViewPagerAdapter;
import com.iotblue.weatherapp.presentation.views.BookmarkDetailsFragment;
import com.iotblue.weatherapp.presentation.views.BookmarksListFragment;
import com.iotblue.weatherapp.presentation.views.MapFragment;

public class HomeActivity extends AppCompatActivity implements BookmarksListFragment.OnFragmentInteractionListener {


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
        adapter.addFragment(new MapFragment(), "Locator");
        adapter.addFragment(new BookmarksListFragment(), "Bookmarks");
        adapter.addFragment(new BookmarkDetailsFragment(), "Forecast");
        viewPager.setAdapter(adapter);
    }


    @Override
    public void onFragmentCallback() {
        viewPager.setCurrentItem(3);
    }
}
