package com.example.ahmed.popular_movies.application;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

/**
 * Created by ahmed on 2/4/2018.
 */

public class MoviesApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AndroidNetworking.initialize(getApplicationContext());

    }
}
