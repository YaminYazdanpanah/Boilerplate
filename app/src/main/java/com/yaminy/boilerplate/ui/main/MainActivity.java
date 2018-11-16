package com.yaminy.boilerplate.ui.main;

import android.content.Context;
import android.location.LocationListener;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yaminy.boilerplate.R;
import com.yaminy.boilerplate.ui.base.BaseActivity;

import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends BaseActivity
        implements MainMvpView {

    MainPresenter<MainMvpView> mainPresenter = new MainPresenter<>();


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter.onAttach(this);
    }
}
