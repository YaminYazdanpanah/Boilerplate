package com.kasra.hamrah.data;

import android.content.Context;


import com.kasra.hamrah.data.network.ApiBaseCreator;
import com.kasra.hamrah.data.network.ApiHeader;
import com.kasra.hamrah.data.preferences.AppPreferences;



public class AppDataManager implements AppDataManagerHelper {

    private AppPreferences appPreferences;
    private static AppDataManager appDataManager;
    private final ApiHeader apiHeader;

    public static AppDataManager getInstance(Context context) {
        if (appDataManager == null) {
            appDataManager = new AppDataManager(AppPreferences.getInstance(context), ApiBaseCreator.getApiHeader(""));
        }
        return appDataManager;
    }

    public AppDataManager(AppPreferences appPreferences, ApiHeader apiHeader) {
        this.appPreferences = appPreferences;
        this.apiHeader = apiHeader;
    }

    public AppDataManager(Context context) {
        this.appPreferences = AppPreferences.getInstance(context);
        this.apiHeader = null;
    }
    //<<<<<<<<< API CALLS ARE HERE >>>>>>>>
//    @Override
//    public Call<LoginResponse> doLoginApiCall(String grantType, String userName, String password, String clientId, final Callback<LoginResponse> callback) {
//        Call<LoginResponse> call = ApiBaseCreator.getApiHeader("").loginPostRequest(grantType, userName, password, clientId);
//        call.enqueue(new Callback<LoginResponse>() {
//            @Override
//            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                if (response.isSuccessful()) {
//                }
//                callback.onResponse(call, response);
//
//            }
//
//            @Override
//            public void onFailure(Call<LoginResponse> call, Throwable t) {
//                callback.onFailure(call, t);
//
//            }
//
//        });
//        return call;
//    }

    //<<<<<<<<< SHARED PREFS ARE HERE >>>>>>>>
    @Override
    public void cleanAllThings() {
        appPreferences.clearAllThings();
    }


}
