package com.iotblue.weatherapp.presentation.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.iotblue.weatherapp.data.domain.entities.Bookmark;
import com.iotblue.weatherapp.data.repository.BookmarksRepository;


public class BookMarksViewModel extends AndroidViewModel {

    MutableLiveData<Bookmark> bookmarkMutableLiveData = new MutableLiveData<Bookmark>();
    private BookmarksRepository bookmarksRepository;


    public BookMarksViewModel(@NonNull Application application, BookmarksRepository bookmarksRepository) {
        super(application);
        this.bookmarksRepository = bookmarksRepository;
    }


}
