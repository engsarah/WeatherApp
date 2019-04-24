package com.iotblue.weatherapp.presentation.views;

import android.view.View;

import com.iotblue.weatherapp.data.domain.entities.Bookmark;


public interface IOnItemClickListener {
    void onItemClick(View view, int position, Bookmark bookmark);
}
