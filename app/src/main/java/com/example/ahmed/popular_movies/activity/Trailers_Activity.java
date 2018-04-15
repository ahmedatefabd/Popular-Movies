package com.example.ahmed.popular_movies.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.ahmed.popular_movies.model.ResponseTrailes;
import com.example.ahmed.popular_movies.util.constant;
import com.androidnetworking.AndroidNetworking;
import com.example.ahmed.popular_movies.R;
import com.example.ahmed.popular_movies.adapter.TrailerAdapter;
import com.example.ahmed.popular_movies.model.Trailer;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Trailers_Activity extends AppCompatActivity {

    @BindView(R.id.trailers_recycler)
    RecyclerView trailersRecycler;
    @BindView(R.id.trailers_progressBar)
    ProgressBar trailersProgressBar;

    private TrailerAdapter adapter ;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailers_);
        ButterKnife.bind(Trailers_Activity.this);

//        Bundle intent = getIntent().getExtras();

        id = getIntent().getExtras().getString(constant.EXTRA.ID_MOVIE);

        loadTrailer(id);

    }

    private void loadTrailer(String id) {
        trailersProgressBar.setVisibility(View.VISIBLE);

        AndroidNetworking.get(constant.Api.BASE_URL + constant.Api.MOVIE_GET_VIDEO_LINK)
                .addQueryParameter( constant.Api.TOKEN_NAME , constant.Api.TOKEN_VALUE )
                .addPathParameter( constant.Api.KEY_ID_GET_VIDEO , id )
                .build()
                .getAsObject(ResponseTrailes.class, new ParsedRequestListener<ResponseTrailes>() {

                    @Override
                    public void onResponse(ResponseTrailes response) {
                        trailersProgressBar.setVisibility(View.GONE);

                        RecyclerTrailer(response);
                    }

                    @Override
                    public void onError(ANError anError) {
                        trailersProgressBar.setVisibility(View.GONE);

                        Toast.makeText(Trailers_Activity.this, "anError" + anError.getErrorDetail(), Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private void RecyclerTrailer(ResponseTrailes response) {

        adapter = new TrailerAdapter(Trailers_Activity.this , response.getTrailes());
        trailersRecycler.setLayoutManager(new LinearLayoutManager(Trailers_Activity.this));
        trailersRecycler.setAdapter(adapter);
    }
}
