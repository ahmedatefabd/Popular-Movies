package com.example.ahmed.popular_movies.util;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by ahmed on 5/4/2018.
 */

public class Connection extends Application{

    public static boolean isNetworkAvailable(Context context) {
        final ConnectivityManager connectivityManager
                = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

//    private static Connection singleton = null ;
//
//    private Connection() {}
//
//    public static Connection getSingleton() {
//
//        if (singleton == null){
//            synchronized(Connection.class){
//                if (singleton == null) {
//
//                    isNetworkAvailable(Connection.this);
//
//                    singleton = new Connection();
//                }
//            }
//        }
//        return singleton;
//    }
//
//    public static boolean isNetworkAvailable(Context context) {
//        final ConnectivityManager connectivityManager = ((ConnectivityManager) context
//                .getSystemService(Context.CONNECTIVITY_SERVICE));
//        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
//    }
}
