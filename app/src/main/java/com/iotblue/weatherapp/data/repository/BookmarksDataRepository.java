package com.iotblue.weatherapp.data.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.iotblue.weatherapp.data.database.BookmarksDatabase;
import com.iotblue.weatherapp.data.database.dao.BookmarksDao;
import com.iotblue.weatherapp.data.domain.entities.Bookmark;

import java.util.List;

public class BookmarksDataRepository implements BookmarksRepository, ReverseGeocodeCallback {

    MutableLiveData<Boolean> isBookmarkSaved = new MutableLiveData<Boolean>();
    private BookmarksDatabase db;


    public BookmarksDataRepository(Context context) {
        db = BookmarksDatabase.getInstance(context);
    }

    @Override
    public void saveBookmark(String latlng) {

        //new GoogleReverseGeocodeService().getLocationAddress(latlng, this);
//        Bookmark b0 = new Bookmark();
//        b0.setId(1);
//        b0.setLat(40.714224);
//        b0.setLng(-73.961452);
//        b0.setAddress("277 Bedford Avenue, Brooklyn, NY 11211, USA");
//        onSuccess(b0);
//        Bookmark b01 = new Bookmark();
//        b01.setId(2);
//        b01.setLat(40.714224);
//        b01.setLng(-73.961452);
//        b01.setAddress("277 Bedford Avenue, Brooklyn, NY 11211, USA");
//        onSuccess(b01);
        Bookmark b02 = new Bookmark();
        b02.setId(3);
        b02.setLat(40.714224);
        b02.setLng(-73.961452);
        b02.setAddress("277 Bedford Avenue, Brooklyn, NY 11211, USA");
        onSuccess(b02);

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
        isBookmarkSaved.setValue(false);
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
