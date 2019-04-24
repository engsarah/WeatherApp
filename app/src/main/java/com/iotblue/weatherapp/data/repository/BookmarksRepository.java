package com.iotblue.weatherapp.data.repository;

import androidx.lifecycle.LiveData;

import com.iotblue.weatherapp.data.domain.entities.Bookmark;

import java.util.List;

public interface BookmarksRepository {

    void saveBookmark(String lat, String lon);

    LiveData<List<Bookmark>> getAllBookmarks();

    void deleteBookmark(Bookmark bookmark);
}
