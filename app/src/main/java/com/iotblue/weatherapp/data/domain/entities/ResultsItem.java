package com.iotblue.weatherapp.data.domain.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ResultsItem {

    @SerializedName("formatted_address")
    private String formattedAddress;

    @SerializedName("types")
    private List<String> types;

    @SerializedName("geometry")
    private Geometry geometry;

    @SerializedName("address_components")
    private List<AddressComponentsItem> addressComponents;

    @SerializedName("plus_code")
    private PlusCode plusCode;

    @SerializedName("place_id")
    private String placeId;

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public List<AddressComponentsItem> getAddressComponents() {
        return addressComponents;
    }

    public void setAddressComponents(List<AddressComponentsItem> addressComponents) {
        this.addressComponents = addressComponents;
    }

    public PlusCode getPlusCode() {
        return plusCode;
    }

    public void setPlusCode(PlusCode plusCode) {
        this.plusCode = plusCode;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    @Override
    public String toString() {
        return
                "ResultsItem{" +
                        "formatted_address = '" + formattedAddress + '\'' +
                        ",types = '" + types + '\'' +
                        ",geometry = '" + geometry + '\'' +
                        ",address_components = '" + addressComponents + '\'' +
                        ",plus_code = '" + plusCode + '\'' +
                        ",place_id = '" + placeId + '\'' +
                        "}";
    }
}