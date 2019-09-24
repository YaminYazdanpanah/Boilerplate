package com.kasra.kasrahamrah.data.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.kasra.kasrahamrah.R;
import com.kasra.kasrahamrah.data.database.AppDao;


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

