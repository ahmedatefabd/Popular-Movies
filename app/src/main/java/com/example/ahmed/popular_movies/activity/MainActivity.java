package com.example.ahmed.popular_movies.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.ahmed.popular_movies.model.Response;
import com.example.ahmed.popular_movies.util.constant;
import com.androidnetworking.AndroidNetworking;
import com.example.ahmed.popular_movies.R;
import com.example.ahmed.popular_movies.adapter.MoviesAdapter;
import com.example.ahmed.popular_movies.model.Movie;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.movie_recycler)
    RecyclerView movieRecycler;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private MoviesAdapter adapter ;// referance --> class_Adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);

        downloadMovies(constant.Api.POPULAR_MOVIES_KEY);// Method download Movies by Library-->Fastnetwark
    }



    // Method download Movies by Library-->Fastnetwark
    private void downloadMovies(String typeMovie) {
        progressBar.setVisibility(View.VISIBLE);


        AndroidNetworking.get(constant.Api.BASE_URL + typeMovie ) // BASE_URL-->link-->class->constant->package->util
                .addQueryParameter(constant.Api.TOKEN_NAME , constant.Api.TOKEN_VALUE) // token_URL-->key & value-->class->constant->package->util
                .build()
                .getAsObject(Response.class, new ParsedRequestListener<Response>() { // return-->JsonObject--> convert to Object_java in class-->Response contain JsonArray convert to List<Movie> in class Movie

                    @Override
                    public void onResponse(Response response) {
                        progressBar.setVisibility(View.INVISIBLE);


                        recyclerVtew(response);// Method Recycler & Adapter


                        // mmkn a3rf el recycler hnaaa w mmkn a3malo fe method lwa7do braaa

//                        adapter = new MoviesAdapter(MainActivity.this, response.getMovies() );
//                        movieRecycler.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
//                        movieRecycler.setAdapter(adapter);


                    }



                    @Override
                    public void onError(ANError anError) {
                        progressBar.setVisibility(View.INVISIBLE);

                        Toast.makeText(MainActivity.this, anError.getErrorDetail(), Toast.LENGTH_SHORT).show();

                    }
                });
    }




    // Method Recycler & Adapter
    public void recyclerVtew(Response response){

        adapter = new MoviesAdapter(MainActivity.this, response.getMovies() );

        movieRecycler.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        movieRecycler.setAdapter(adapter);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){

            case R.id.popular:
                downloadMovies(constant.Api.POPULAR_MOVIES_KEY);// Method download Movies by Library-->Fastnetwark

            case R.id.top_rated:
                downloadMovies(constant.Api.TOP_RATED_MOVIES_KEY);// Method download Movies by Library-->Fastnetwark

        }
        return super.onOptionsItemSelected(item);
    }
}
