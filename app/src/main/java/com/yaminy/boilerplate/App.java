package com.yaminy.boilerplate;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class App extends Application {

    public static Context context;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getBaseContext();
        addCalligraphy();
    }

    private void addCalligraphy() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(context.getResources().getString(R.string.font_path))
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

}
