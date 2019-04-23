package com.iotblue.weatherapp.presentation.viewmodels;

import androidx.lifecycle.ViewModel;

import com.iotblue.weatherapp.data.repository.BookmarksRepository;


public class BookMarksViewModel extends ViewModel {

    private BookmarksRepository bookmarksRepository;

    //@Inject
    public BookMarksViewModel(BookmarksRepository bookmarksRepository) {
        this.bookmarksRepository = bookmarksRepository;
    }
}
