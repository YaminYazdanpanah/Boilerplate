package com.kasra.hamrah.ui.base;

import com.kasra.hamrah.data.database.AppDao;
import com.kasra.hamrah.data.database.AppDatabase;
import com.kasra.hamrah.data.preferences.AppPreferences;

public class BasePresenter <V extends BaseView> implements BasePresenterView<V> {
    private V mBaseView;

    @Override
    public void onAttach(V BaseView) {
        mBaseView = BaseView;
    }

    @Override
    public V getMvpView() {
        return mBaseView;
    }

    @Override
    public AppPreferences getPrefrencesPresenter() {
        return AppPreferences.getInstance(mBaseView.getContext());

    }

    @Override
    public AppDao getDao() {
        return AppDatabase.getAppDao(mBaseView.getContext()).appDao();

    }
}

