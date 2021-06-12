package com.example.mobileproject;

import android.content.Context;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Articles.class}, version = 1)
public abstract class GolazoDatabase extends RoomDatabase {
    private static GolazoDatabase database;
    public abstract UserDao userDao();

    public static GolazoDatabase getInstance (Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context, GolazoDatabase.class, "golanzoDatabase").allowMainThreadQueries().build();
        }
        return database;
    }
}
