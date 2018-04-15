package com.example.ahmed.popular_movies.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ahmed.popular_movies.R;
import com.example.ahmed.popular_movies.model.Movie;
import com.example.ahmed.popular_movies.model.Trailer;
import com.example.ahmed.popular_movies.util.FormatDate;
import com.example.ahmed.popular_movies.util.constant;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Details_Activity extends AppCompatActivity {

    @BindView(R.id.cover_img)
    ImageView coverImg;
    @BindView(R.id.poster_img)
    ImageView posterImg;
    @BindView(R.id.movie_title)
    TextView movieTitle;
    @BindView(R.id.movie_rating)
    TextView movieRating;
    @BindView(R.id.movie_release_date)
    TextView movieReleaseDate;
    @BindView(R.id.movie_description)
    TextView movieDescription;
    @BindView(R.id.movie_trailers_btn)
    Button movieTrailersBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_);
        ButterKnife.bind(Details_Activity.this);

        Bundle intent = getIntent().getExtras();

        final Movie movie = intent.getParcelable(constant.EXTRA.MOVIE);

        Picasso.with(Details_Activity.this)
                .load(constant.Api.BASE_IMAGE_URL + movie.getBackdrop_path())
                .into(posterImg);

        Picasso.with(Details_Activity.this)
                .load(constant.Api.BASE_IMAGE_URL + movie.getPoster_path())
                .into(coverImg);

        movieTitle.setText("Title : " + movie.getTitle());
        movieRating.setText("Rating : " + movie.getVote_average());

        //formatDate()-->static method is used for change the date format ("yyyy-MM-dd") to ("dd-MM-yyyy")
        //formatDate()-->static method is inside Class-->(FormatDate) inside package-->(util)
        movieReleaseDate.setText("FormatDate : " + FormatDate.formatDate(movie.getRelease_date()));
        movieDescription.setText("Description : " + movie.getOverview());
        movieTrailersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(Details_Activity.this , Trailers_Activity.class);

                intent1.putExtra(constant.EXTRA.ID_MOVIE , movie.getId());

                startActivity(intent1);
            }
        });


    }

}
