package com.iotblue.weatherapp.data.domain.entities;

import com.google.gson.annotations.SerializedName;


public class Geometry {

    @SerializedName("viewport")
    private Viewport viewport;

    @SerializedName("bookmark")
    private Bookmark bookmark;

    @SerializedName("location_type")
    private String locationType;

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    public Bookmark getBookmark() {
        return bookmark;
    }

    public void setBookmark(Bookmark bookmark) {
        this.bookmark = bookmark;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    @Override
    public String toString() {
        return
                "Geometry{" +
                        "viewport = '" + viewport + '\'' +
                        ",bookmark = '" + bookmark + '\'' +
                        ",location_type = '" + locationType + '\'' +
                        "}";
    }
}