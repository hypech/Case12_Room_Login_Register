package com.hypech.case9login_room.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities={User.class}, version =1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    //Define the DAOs that work with the database. Provide an abstract "getter" method.
    public abstract UserDao userDao();

    //Create the WordRoomDatabase as a singleton
    private static volatile UserDatabase INSTANCE;
    public static synchronized UserDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "db_room.DB")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}