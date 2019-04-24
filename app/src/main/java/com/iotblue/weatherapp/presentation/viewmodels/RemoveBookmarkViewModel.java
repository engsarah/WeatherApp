package com.iotblue.weatherapp.presentation.viewmodels;


import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.iotblue.weatherapp.data.domain.entities.Bookmark;
import com.iotblue.weatherapp.data.repository.BookmarksDataRepository;
import com.iotblue.weatherapp.data.repository.BookmarksRepository;

public class RemoveBookmarkViewModel extends AndroidViewModel {

    private BookmarksRepository bookmarksRepository;

    public RemoveBookmarkViewModel(@NonNull Application application) {
        super(application);
        bookmarksRepository = new BookmarksDataRepository(application.getApplicationContext());

    }

    public void deleteLBookmark(Bookmark bookmark) {
        DeleteItemTask deleteItemTask = new DeleteItemTask();
        deleteItemTask.execute(bookmark);
    }

    private class DeleteItemTask extends AsyncTask<Bookmark, Void, Void> {

        @Override
        protected Void doInBackground(Bookmark... bookmarks) {
            bookmarksRepository.deleteBookmark(bookmarks[0]);
            return null;
        }
    }

}

