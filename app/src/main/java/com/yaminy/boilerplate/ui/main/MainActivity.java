package com.yaminy.boilerplate.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.yaminy.boilerplate.R;
import com.yaminy.boilerplate.ui.base.BaseActivity;
import com.yaminy.boilerplate.ui.camera.CameraFragment;
import com.yaminy.boilerplate.ui.gallery.GalleryFragment;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainMvpView {

    MainPresenter<MainMvpView> mainPresenter = new MainPresenter<>();
    android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();


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

        initView();

    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NotNull MenuItem item) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            handleNavigationItemSelected(true, false, false, false, false, false);
            return true;

        } else if (id == R.id.nav_gallery) {
            handleNavigationItemSelected(false, true, false, false, false, false);
            return true;

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        return true;
    }

    public boolean handleNavigationItemSelected(boolean isShowCamera, boolean isShowGallery, boolean isShowSlideShow, boolean isShowManage, boolean isShowShare, boolean isShowSend) {
        if (isShowCamera) {
            if (fragmentManager.findFragmentByTag("Camera") != null) {
                fragmentManager.beginTransaction().show(Objects.requireNonNull(fragmentManager.findFragmentByTag("Camera"))).commitAllowingStateLoss();
            } else {
                fragmentManager.beginTransaction().add(R.id.rootLayout, new CameraFragment(), "Camera").commitAllowingStateLoss();
            }
        } else {
            if (fragmentManager.findFragmentByTag("Camera") != null) {
                fragmentManager.beginTransaction().hide(Objects.requireNonNull(fragmentManager.findFragmentByTag("Camera"))).commitAllowingStateLoss();
            }
        }
        if (isShowGallery) {
            if (fragmentManager.findFragmentByTag("Gallery") != null) {
                fragmentManager.beginTransaction().show(Objects.requireNonNull(fragmentManager.findFragmentByTag("Gallery"))).commitAllowingStateLoss();
            } else {
                fragmentManager.beginTransaction().add(R.id.rootLayout, new GalleryFragment(), "Gallery").commitAllowingStateLoss();
            }

        } else {
            if (fragmentManager.findFragmentByTag("Gallery") != null) {
                fragmentManager.beginTransaction().hide(Objects.requireNonNull(fragmentManager.findFragmentByTag("Gallery"))).commitAllowingStateLoss();
            }
        }
        return true;
    }


}
