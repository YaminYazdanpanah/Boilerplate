package com.kasra.kasrahamrah.ui.base;

public interface BasePresenterView <V extends BaseView> {
    void onAttach(V BaseView);
    V getMvpView();
//    AppPreferences getPrefrencesPresenter();
//    BimerDao getatencyDao();
}

