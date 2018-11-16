package com.yaminy.boilerplate.data.database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.yaminy.boilerplate.R;

//@Database(entities = {UserInfo.class}, version = 1)
//@TypeConverters({ProductTypeConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract AppDao appDao();

    private static AppDatabase db = null;

    public static AppDatabase getAppDao(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,String.valueOf(R.string.db_name))
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return db;
    }

}

