package com.yaminy.boilerplate.ui.base;

public interface  BaseHelper<V extends BaseView> {
    void onAttach(V BaseView);
    V getMvpView();

}
