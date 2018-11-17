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
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.movie_recycler)
    RecyclerView movieRecycler;

    private ShimmerFrameLayout mShimmerViewContainer;
    private MoviesAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(MainActivity.this);
        mShimmerViewContainer = findViewById(R.id.shimmer_view_container);
        downloadMovies(constant.Api.POPULAR_MOVIES_KEY);
    }
    private void downloadMovies(String typeMovie) {
        AndroidNetworking.get(constant.Api.BASE_URL + typeMovie )
                .addQueryParameter(constant.Api.TOKEN_NAME , constant.Api.TOKEN_VALUE)
                .build()
                .getAsObject(Response.class, new ParsedRequestListener<Response>() {
                    @Override
                    public void onResponse(Response response) {
                        recyclerVtew(response);
                        mShimmerViewContainer.stopShimmerAnimation();
                        mShimmerViewContainer.setVisibility(View.GONE);
                    }
                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(MainActivity.this, anError.getErrorDetail(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
    public void recyclerVtew(Response response){
        adapter = new MoviesAdapter(MainActivity.this, response.getMovies() );
        movieRecycler.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        movieRecycler.setAdapter(adapter);
    }
    @Override
    public void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
    }
    @Override
    public void onPause() {
        mShimmerViewContainer.stopShimmerAnimation();
        super.onPause();
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
                return true;
            case R.id.top_rated:
                downloadMovies(constant.Api.TOP_RATED_MOVIES_KEY);// Method download Movies by Library-->Fastnetwark
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
