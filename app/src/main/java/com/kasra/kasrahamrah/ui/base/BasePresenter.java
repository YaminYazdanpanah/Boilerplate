package com.kasra.kasrahamrah.ui.base;

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

//    @Override
//    public AppPreferences getPrefrencesPresenter() {
//        return AppPreferences.getInstance(mBaseView.getContext());
//
//    }

//    @Override
//    public BimerDao getatencyDao() {
//        return BimerDatabase.getAtencyDb(mBaseView.getContext()).atencyDao();
//
//    }
}

