package com.kasra.hamrah;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class KasraHamrah extends Application {

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
        initialLogger();
    }

    private void initialLogger() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(1)         // (Optional) How many method line to show. Default 2
                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
//                .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag(context.getString(R.string.app_name))   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }

    private void addCalligraphy() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(context.getResources().getString(R.string.font_path))
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

}