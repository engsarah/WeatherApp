package com.iotblue.weatherapp.data.domain.entities;

import com.google.gson.annotations.SerializedName;


public class Clouds {

    @SerializedName("all")
    private int all;

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

}