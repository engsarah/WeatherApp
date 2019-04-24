package com.iotblue.weatherapp.data.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.iotblue.weatherapp.data.database.BookmarksDatabase;
import com.iotblue.weatherapp.data.database.dao.BookmarksDao;
import com.iotblue.weatherapp.data.domain.entities.Bookmark;
import com.iotblue.weatherapp.data.network.openwheatherapi.OpenWeatherMapService;

import java.util.List;

public class BookmarksDataRepository implements BookmarksRepository, OnBackendCallFinished {

    MutableLiveData<Boolean> isBookmarkSaver = new MutableLiveData<Boolean>();
    private BookmarksDatabase db;


    public BookmarksDataRepository(Context context) {
        db = BookmarksDatabase.getInstance(context);
    }

    @Override
    public void saveBookmark(String lat, String lon) {

        new OpenWeatherMapService().getWeatherDetails(lat, lon, this);
    }

    @Override
    public LiveData<List<Bookmark>> getAllBookmarks() {
        return db.getBookmarksDao().getAllBookmarks();
    }

    @Override
    public void deleteBookmark(Bookmark bookmark) {
        db.getBookmarksDao().delete(bookmark);
    }


    @Override
    public void onSuccess(Bookmark bookmark) {
        new addBookmarkAsyncTask(db.getBookmarksDao()).execute(bookmark);

    }

    @Override
    public void onError(String error) {
        isBookmarkSaver.setValue(false);
    }

    private static class addBookmarkAsyncTask extends AsyncTask<Bookmark, Void, Void> {

        BookmarksDao bookmarksDao;
        MutableLiveData<Boolean> isBookMarkAddedSuccessfully = new MutableLiveData<>();

        public addBookmarkAsyncTask(BookmarksDao bookmarksDao) {
            this.bookmarksDao = bookmarksDao;
        }

        @Override
        protected Void doInBackground(Bookmark... bookmarks) {
            bookmarksDao.insert(bookmarks[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            isBookMarkAddedSuccessfully.setValue(Boolean.TRUE);

        }
    }
}
