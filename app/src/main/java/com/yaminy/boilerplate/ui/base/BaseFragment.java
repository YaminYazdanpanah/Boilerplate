package com.yaminy.boilerplate.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.muddzdev.styleabletoastlibrary.StyleableToast;
import com.yaminy.boilerplate.R;
import com.yaminy.boilerplate.utils.ShowLoading;

public class BaseFragment extends Fragment {

    Context context;
    ProgressDialog progressDialog;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context != null) {
            this.context = context;
        }
    }

    public void showMessage(String message) {
        if (message != null && context != null) {
            new StyleableToast
                    .Builder(context)
                    .text(message)
                    .textColor(context.getResources().getColor(R.color.colorPrimaryDark))
                    .backgroundColor(context.getResources().getColor(R.color.colorWhite))
                    .stroke(1, context.getResources().getColor(R.color.colorWhite))
                    .show();
        }
    }

    public void showErrorMessage(String message) {
        if (message != null && context != null) {
            new StyleableToast
                    .Builder(context)
                    .text(message)
                    .textColor(context.getResources().getColor(R.color.colorWhite))
                    .backgroundColor(context.getResources().getColor(R.color.colorRed))
                    .stroke(1, context.getResources().getColor(R.color.colorWhite))
                    .show();
        }
    }

    public void showProgress() {
        if (progressDialog == null || !progressDialog.isShowing())
            progressDialog = ShowLoading.showLoadingDialog(context);
    }

    public void hideProgress() {
        if (progressDialog != null)
            if (progressDialog.isShowing())
                progressDialog.dismiss();
    }

}
