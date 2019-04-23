package com.iotblue.weatherapp.presentation.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.iotblue.weatherapp.data.repository.BookmarksDataRepository;
import com.iotblue.weatherapp.data.repository.BookmarksRepository;

public class AddBookmarkViewModel extends AndroidViewModel {


    private MutableLiveData<Boolean> isLocationAdded = new MutableLiveData<Boolean>();
    private BookmarksRepository bookmarksRepository;

    public AddBookmarkViewModel(@NonNull Application application) {
        super(application);
        bookmarksRepository = new BookmarksDataRepository(application.getApplicationContext());
    }

    public void saveBookmarkedLocation(String lat, String lon) {
        bookmarksRepository.saveBookmark(lat, lon);
    }

    public MutableLiveData<Boolean> isLocationAdded() {
        return isLocationAdded;
    }

}
