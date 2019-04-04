package com.yaminy.boilerplate.data.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBaseCreator {
    public static ApiHeader getApiHeader(String subdomain) {


        String REST_API_BASE_URL = "http://";
        REST_API_BASE_URL += subdomain + "atency.panel";

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
//        gsonBuilder.registerTypeAdapter(Date.class, new UtcDateTypeAdapter());
        Gson gson = gsonBuilder.create();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
//                .authenticator(new TokenAuthenticator())
                .retryOnConnectionFailure(false)
                .addInterceptor(logging)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(REST_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        return retrofit.create(ApiHeader.class);

    }
}

