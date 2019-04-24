package com.iotblue.weatherapp.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.iotblue.weatherapp.data.database.dao.BookmarksDao;
import com.iotblue.weatherapp.data.database.utils.DBConstants;
import com.iotblue.weatherapp.data.domain.entities.Bookmark;


@Database(entities = {Bookmark.class}, version = 2, exportSchema = false)
public abstract class BookmarksDatabase extends RoomDatabase {

    private static BookmarksDatabase bookmarksDatabase;

    public static synchronized BookmarksDatabase getInstance(Context context) {
        if (null == bookmarksDatabase) {
            return Room.databaseBuilder(context.getApplicationContext(), BookmarksDatabase.class, DBConstants.DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return bookmarksDatabase;
    }

    public abstract BookmarksDao getBookmarksDao();

    public void cleanUp() {
        bookmarksDatabase = null;
    }

}
