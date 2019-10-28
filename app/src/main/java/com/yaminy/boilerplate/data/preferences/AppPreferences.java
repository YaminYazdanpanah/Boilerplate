package com.yaminy.boilerplate.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.yaminy.boilerplate.App;
import com.yaminy.boilerplate.R;

public class AppPreferences implements AppPreferencesHelper {
    private static AppPreferences appPreferences;
    private SharedPreferences preferences;
    private Context context;

    public static AppPreferences getInstance(Context context) {
        if (context == null) {
            context = App.getContext();
        }
        if (appPreferences == null) {
            appPreferences = new AppPreferences(context);
        }
        return appPreferences;
    }

    public AppPreferences(Context context) {
        if (context == null) {
            context = App.getContext();
        }
        preferences = context.getSharedPreferences(context.getResources().getString(R.string.app_name) + "prefs", Context.MODE_PRIVATE);
        this.context = context;
    }

    @Override
    public void clearAllThings() {
        preferences = context.getSharedPreferences(context.getResources().getString(R.string.app_name)+"prefs", Context.MODE_PRIVATE);
        preferences.edit().clear().apply();

    }

}
