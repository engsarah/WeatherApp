package com.iotblue.weatherapp.presentation.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.iotblue.weatherapp.data.domain.entities.Bookmark;
import com.iotblue.weatherapp.data.repository.BookmarksDataRepository;
import com.iotblue.weatherapp.data.repository.BookmarksRepository;

import java.util.List;


public class BookmarksListViewModel extends AndroidViewModel {

    private BookmarksRepository bookmarksRepository;


    public BookmarksListViewModel(@NonNull Application application) {
        super(application);
        bookmarksRepository = new BookmarksDataRepository(application.getApplicationContext());
    }

    public LiveData<List<Bookmark>> getAllBookmarks() {
        return bookmarksRepository.getAllBookmarks();
    }


}
