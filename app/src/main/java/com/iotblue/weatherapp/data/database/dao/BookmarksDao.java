package com.iotblue.weatherapp.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.iotblue.weatherapp.data.domain.entities.Bookmark;

import java.util.List;

@Dao
public interface BookmarksDao {

    /**
     * @return all bookmarks
     */
    @Query("SELECT * FROM Bookmark")
    LiveData<List<Bookmark>> getAllBookmarks();


    /**
     * @param bookmarkId
     * @return Bookmark in case available in DB
     */
    @Query("SELECT * FROM Bookmark WHERE id = :bookmarkId")
    Bookmark findBookmarkById(int bookmarkId);


    /*
     * Insert the object in database
     * @param item, object to be inserted
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Bookmark bookmark);

    /*
     * Insert list of objects in database
     * @param items, object to be inserted
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertAll(List<Bookmark> bookmarkList);

    /*
     * update the object in database
     * @param item, object to be updated
     */
    @Update
    void update(Bookmark bookmark);

    /*
     * delete the object from database
     * @param item, object to be deleted
     */
    @Delete
    void delete(Bookmark bookmark);

    /*
     * delete list of objects from database
     * @param item, array of objects to be deleted
     */
    @Delete
    void delete(Bookmark... bookmarks);


}
