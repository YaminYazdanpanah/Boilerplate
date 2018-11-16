package com.yaminy.boilerplate.ui.base;

import android.content.Context;

public interface BaseView {
    Context getContext();
    void showErrorMessage(String message);
    void showMessage(String message);
    void showProgress();
    void hideProgress();

}
