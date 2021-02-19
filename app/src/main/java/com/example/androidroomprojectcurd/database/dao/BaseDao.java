package com.example.androidroomprojectcurd.database.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

public interface BaseDao<T> {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(T t);

    @Delete
    void delete(T t);

    @Update
    void update(T t);

}
