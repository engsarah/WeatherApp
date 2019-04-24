package com.iotblue.weatherapp.data.domain.entities;

import com.google.gson.annotations.SerializedName;

public class Rain {

    @SerializedName("1h")
    String rainLast1Hour;
    @SerializedName("3h")
    String rainLast3Hour;

    public String getRainLast1Hour() {
        return rainLast1Hour;
    }

    public void setRainLast1Hour(String rainLast1Hour) {
        this.rainLast1Hour = rainLast1Hour;
    }

    public String getRainLast3Hour() {
        return rainLast3Hour;
    }

    public void setRainLast3Hour(String rainLast3Hour) {
        this.rainLast3Hour = rainLast3Hour;
    }
}
