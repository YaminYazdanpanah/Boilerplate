package com.yaminy.boilerplate.ui.gallery;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yaminy.boilerplate.R;
import com.yaminy.boilerplate.ui.base.BaseFragment;
import com.yaminy.boilerplate.ui.camera.CameraMvpView;
import com.yaminy.boilerplate.ui.camera.CameraPresenter;

import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class GalleryFragment extends BaseFragment implements GalleryMvpView {

    GalleryPresenter<GalleryMvpView> galleryPresenter = new GalleryPresenter<>();
    Context context;
    ViewGroup containerGroup;


    @Override
    public void onAttach(Context context) {
        super.onAttach(CalligraphyContextWrapper.wrap(context));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        galleryPresenter.onAttach(this);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        ButterKnife.bind(this, view);
        this.context = view.getContext();
        this.containerGroup = container;
        return view;
    }
}
