package com.iotblue.weatherapp.data.domain.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Bookmark {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    @ColumnInfo(name = "countryCode")
    private String countryCode;
    private String cityName;
    private String cityId;
    private String description;
    private String icon;
    private String maxTemperature;
    private String minTemperature;
    private String humidity;
    private String windSpeed;
    private String windDegree;
    private String date;
    private String rainLastHour;
    private String rainLastThreeHours;
    private String clouds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(String minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(String windDegree) {
        this.windDegree = windDegree;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRainLastHour() {
        return rainLastHour;
    }

    public void setRainLastHour(String rainLastHour) {
        this.rainLastHour = rainLastHour;
    }

    public String getRainLastThreeHours() {
        return rainLastThreeHours;
    }

    public void setRainLastThreeHours(String rainLastThreeHours) {
        this.rainLastThreeHours = rainLastThreeHours;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }
}
