package com.example.ahmed.popular_movies.util;

/**
 * Created by ahmed on 2/4/2018.
 */

public interface constant {


    interface Api{
        // for (FastNetwark) --> (JsonObject)_____(JsonArray)____(Links)


        //LINK:- (BASE_URL) for any Movie
        String BASE_URL = "https://api.themoviedb.org/3/movie/";

        // addQueryParameter (Token)--->(key , value)
        String TOKEN_NAME = "api_key";  // Keys
        String TOKEN_VALUE = "0bf0eb9df7442da9952998a260bd0cde";  // Values

        // addQueryParameter (LINK:- Type of Movies Loaded)---> Type Loading Movies (popular)----(top_rated)
        String POPULAR_MOVIES_KEY = "popular";
        String TOP_RATED_MOVIES_KEY = "top_rated";

        //Picasso (LINK:- BASE_IMAGE_URL)
        String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500";


        //LINK:- GET_Movies_videos
        String MOVIE_GET_VIDEO_LINK = "{movie_id}/videos" ;

        // KEY---> addPathParameter (LINK:- {movie_id})------> Change (id)
        String KEY_ID_GET_VIDEO = "movie_id";

    }

    interface EXTRA {

        String MOVIE = "movie";
        String TRAILER = "trailer";
        String ID_MOVIE = "id";


    }
}
