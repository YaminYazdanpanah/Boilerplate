package com.kasra.hamrah.ui.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.kasra.hamrah.R;
import com.kasra.hamrah.util.MyProgressDialog;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity implements BaseView {
        MyProgressDialog progressBar;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);


    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showErrorMessage(String message) {
        if (message != null) {
            new StyleableToast
                    .Builder(this)
                    .text(message)
                    .textColor(getResources().getColor(R.color.color_white))
                    .backgroundColor(getResources().getColor(R.color.color_red))
                    .stroke(1, getResources().getColor(R.color.color_white))
                    .show();
        }
    }

    @Override
    public void showMessage(String message) {
        if (message != null) {
            new StyleableToast
                    .Builder(this)
                    .text(message)
                    .textColor(getResources().getColor(R.color.colorPrimaryDark))
                    .backgroundColor(getResources().getColor(R.color.color_white))
                    .stroke(1, getResources().getColor(R.color.colorPrimaryDark))
                    .show();
        }
    }

    @Override
    public void showProgress() {
        try {
            if (!(this).isFinishing()) {
                if (progressBar == null || !progressBar.isShowing()){
                    progressBar = new MyProgressDialog(getContext());
                    progressBar.show();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hideProgress() {
        try {
            if (!(this).isFinishing()) {
                if (progressBar != null)
                    if (progressBar.isShowing())
                        progressBar.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void changeStatusColor() {
        Window window = getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
    }

    public Typeface getIranSansTypeFace() {
        return Typeface.createFromAsset(getContext().getAssets(), getContext().getResources().getString(R.string.iransans_font));
    }

    public Typeface getCasablancaTypeFace() {
        return Typeface.createFromAsset(getContext().getAssets(), getContext().getResources().getString(R.string.casablanca_font));
    }

    public Typeface getBHomaTypeFace() {
        return Typeface.createFromAsset(getContext().getAssets(), getContext().getResources().getString(R.string.bhoma_font));
    }

    public Typeface getCasablancaHeavyTypeFace() {
        return Typeface.createFromAsset(getContext().getAssets(), getContext().getResources().getString(R.string.casablanca_heavy_font));
    }

    public Typeface getCasablancaLightTypeFace() {
        return Typeface.createFromAsset(getContext().getAssets(), getContext().getResources().getString(R.string.casablanca_light_font));
    }

}
