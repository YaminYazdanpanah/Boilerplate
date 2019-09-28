package com.kasra.hamrah.ui.base;

import com.kasra.hamrah.data.database.AppDao;
import com.kasra.hamrah.data.preferences.AppPreferences;

public interface BasePresenterView <V extends BaseView> {
    void onAttach(V BaseView);
    V getMvpView();
    AppPreferences getPrefrencesPresenter();
    AppDao getDao();
}

