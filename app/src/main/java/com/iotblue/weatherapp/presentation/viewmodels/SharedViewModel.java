package com.iotblue.weatherapp.presentation.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.iotblue.weatherapp.data.domain.entities.Bookmark;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Bookmark> selected = new MutableLiveData<Bookmark>();

    public void select(Bookmark bookmark) {
        selected.setValue(bookmark);
    }

    public LiveData<Bookmark> getSelected() {
        return selected;
    }
}

