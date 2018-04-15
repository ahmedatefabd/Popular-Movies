package com.example.ahmed.popular_movies.util;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by ahmed on 5/4/2018.
 */

public class Connection {

    public static boolean isNetworkAvailable(Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
