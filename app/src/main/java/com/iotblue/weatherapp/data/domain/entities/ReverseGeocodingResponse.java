package com.iotblue.weatherapp.data.domain.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ReverseGeocodingResponse {

    @SerializedName("results")
    private List<ResultsItem> results;

    public List<ResultsItem> getResults() {
        return results;
    }

    public void setResults(List<ResultsItem> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return
                "ReverseGeocodingResponse{" +
                        "results = '" + results + '\'' +
                        "}";
    }
}