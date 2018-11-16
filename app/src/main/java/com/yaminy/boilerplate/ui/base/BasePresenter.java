package com.yaminy.boilerplate.ui.base;

public class BasePresenter<V extends BaseView> implements BaseHelper<V> {
    private V mBaseView;
    @Override
    public void onAttach(V BaseView) {
        mBaseView=BaseView;
    }
    @Override
    public V getMvpView() {
        return mBaseView;
    }
}

