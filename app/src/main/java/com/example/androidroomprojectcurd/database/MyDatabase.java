package com.example.androidroomprojectcurd.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.androidroomprojectcurd.database.dao.MemberDao;
import com.example.androidroomprojectcurd.database.model.Member;

@Database(entities = {Member.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {


    private static MyDatabase db;


    public abstract MemberDao memberDao();

    public static MyDatabase getDatabase(Context context){
        if(db == null){
            db = Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class, "dbRoom")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return db;
    }
}
