

package com.kasra.kasrahamrah.data.preferences;
import android.content.Context;
import android.content.SharedPreferences;

import com.kasra.kasrahamrah.KasraHamrah;
import com.kasra.kasrahamrah.R;
import com.kasra.kasrahamrah.data.preferences.AppPreferencesHelper;


public class AppPreferences implements AppPreferencesHelper {
    private static AppPreferences appPreferences;
    private SharedPreferences preferences;
    private Context context;

    public static AppPreferences getInstance(Context context) {
        if (context == null) {
            context = KasraHamrah.context;
        }
        if (appPreferences == null) {
            appPreferences = new AppPreferences(context);
        }
        return appPreferences;
    }

    public AppPreferences(Context context) {
        if (context == null) {
            context = KasraHamrah.context;
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
