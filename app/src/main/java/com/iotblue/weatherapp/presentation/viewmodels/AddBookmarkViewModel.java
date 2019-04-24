package com.iotblue.weatherapp.presentation.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.iotblue.weatherapp.data.repository.BookmarksDataRepository;
import com.iotblue.weatherapp.data.repository.BookmarksRepository;

public class AddBookmarkViewModel extends AndroidViewModel {

    private MutableLiveData<Boolean> isLocationAdded;
    private BookmarksRepository bookmarksRepository;

    public AddBookmarkViewModel(@NonNull Application application) {
        super(application);
        bookmarksRepository = new BookmarksDataRepository(application.getApplicationContext());
    }

    public void saveBookmarkedLocation(String latlng) {

        bookmarksRepository.saveBookmark(latlng);
    }

    public MutableLiveData<Boolean> getIsLocationAdded() {
        return isLocationAdded;
    }

}
