package com.example.ahmed.popular_movies.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.ahmed.popular_movies.R;
import com.example.ahmed.popular_movies.activity.Details_Activity;
import com.example.ahmed.popular_movies.model.Movie;
import com.example.ahmed.popular_movies.model.Trailer;
import com.example.ahmed.popular_movies.util.constant;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ahmed on 2/4/2018.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesHolder> {

    private List<Trailer> trailerList ;

    private Context m_context;
    private List<Movie> movieList;


    public MoviesAdapter(Context m_context, List<Movie> movieList) {
        this.m_context = m_context;
        this.movieList = movieList;
    }

    @Override
    public MoviesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(m_context).inflate(R.layout.row, parent, false);
        MoviesHolder holder = new MoviesHolder(row);
        return holder;
    }


    @Override
    public void onBindViewHolder(MoviesHolder holder, int position) {

        final Movie movie = movieList.get(position);
//        final Trailer trailer = trailerList.get(position);


        Picasso.with(m_context)
                .load(constant.Api.BASE_IMAGE_URL + movie.getPoster_path())
                .into(holder.image_Item);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(m_context , Details_Activity.class);

                intent.putExtra(constant.EXTRA.MOVIE , movie);

                m_context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {

        return movieList.size();

    }


    public class MoviesHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_item_movie)
        ImageView image_Item;
        @BindView(R.id.root)
        LinearLayout root; // click on root-->(Linearlayout)----> open new activity --> Detailes By ( intent )

        public MoviesHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
