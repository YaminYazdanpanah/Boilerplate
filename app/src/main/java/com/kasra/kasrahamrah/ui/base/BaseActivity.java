package com.kasra.kasrahamrah.ui.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.kasra.kasrahamrah.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class BaseActivity extends AppCompatActivity implements BaseView {
//    ProgressDialog progressDialog;
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
//        if (message != null) {
//            new StyleableToast
//                    .Builder(this)
//                    .text(message)
//                    .textColor(getResources().getColor(R.color.colorWhite))
//                    .backgroundColor(getResources().getColor(R.color.colorRed))
//                    .stroke(1, getResources().getColor(R.color.colorWhite))
//                    .show();
//        }
    }

    @Override
    public void showMessage(String message) {
//        if (message != null) {
//            new StyleableToast
//                    .Builder(this)
//                    .text(message)
//                    .textColor(getResources().getColor(R.color.colorPrimaryDark))
//                    .backgroundColor(getResources().getColor(R.color.colorWhite))
//                    .stroke(1, getResources().getColor(R.color.colorPrimaryDark))
//                    .show();
//        }
    }

    @Override
    public void showProgress() {
//        try {
//            if (!(this).isFinishing()) {
//                if (progressDialog == null || !progressDialog.isShowing())
//                    progressDialog = ShowLoading.showLoadingDialog(this);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void hideProgress() {
//        try {
//            if (!(this).isFinishing()) {
//                if (progressDialog != null)
//                    if (progressDialog.isShowing())
//                        progressDialog.dismiss();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
    @Override
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void changeStatusColor(){
        Window window = getWindow();
// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
    }


}
