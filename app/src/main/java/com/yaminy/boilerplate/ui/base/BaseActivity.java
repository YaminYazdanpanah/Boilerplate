package com.yaminy.boilerplate.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.muddzdev.styleabletoastlibrary.StyleableToast;
import com.yaminy.boilerplate.R;
import com.yaminy.boilerplate.utils.ShowLoading;

public class BaseActivity extends AppCompatActivity implements BaseView {
    ProgressDialog progressDialog;

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
                    .textColor(getResources().getColor(R.color.colorAccent))
                    .backgroundColor(getResources().getColor(R.color.colorRed))
                    .stroke(1, getResources().getColor(R.color.colorAccent))
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
                    .backgroundColor(getResources().getColor(R.color.colorAccent))
                    .stroke(1, getResources().getColor(R.color.colorAccent))
                    .show();
        }
    }

    @Override
    public void showProgress() {
        if (progressDialog != null && !progressDialog.isShowing())
            progressDialog = ShowLoading.showLoadingDialog(this);
    }

    @Override
    public void hideProgress() {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }

}
