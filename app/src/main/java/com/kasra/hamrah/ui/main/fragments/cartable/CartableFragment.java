package com.kasra.hamrah.ui.main.fragments.cartable;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;

import com.kasra.hamrah.R;
import com.kasra.hamrah.ui.base.BaseFragment;

import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class CartableFragment  extends BaseFragment implements CartableMvpView {

    CartablePresenter<CartableMvpView> presenter = new CartablePresenter<>();
    Context context;
    ViewGroup containerGroup;

    @Override
    public void onAttach(Context context) {
        super.onAttach(CalligraphyContextWrapper.wrap(context));
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.onAttach(this);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cartable, container, false);
        ButterKnife.bind(this, view);
        this.context = view.getContext();
        this.containerGroup = container;
        return view;
    }
}