package com.kasra.kasrahamrah;

import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.kasra.kasrahamrah.util.SetLanguage;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class KasraHamrah extends MultiDexApplication {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(context.getResources().getString(R.string.iransans_font))
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        SetLanguage.updateLanguage(context, "fa-IR");

    }
}