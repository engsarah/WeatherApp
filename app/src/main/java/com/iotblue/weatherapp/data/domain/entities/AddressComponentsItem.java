package com.iotblue.weatherapp.data.domain.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class AddressComponentsItem {

    @SerializedName("types")
    private List<String> types;

    @SerializedName("short_name")
    private String shortName;

    @SerializedName("long_name")
    private String longName;

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    @Override
    public String toString() {
        return
                "AddressComponentsItem{" +
                        "types = '" + types + '\'' +
                        ",short_name = '" + shortName + '\'' +
                        ",long_name = '" + longName + '\'' +
                        "}";
    }
}