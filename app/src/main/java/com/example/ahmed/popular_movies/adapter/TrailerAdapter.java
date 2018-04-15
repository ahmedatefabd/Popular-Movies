package com.example.ahmed.popular_movies.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ahmed.popular_movies.R;
import com.example.ahmed.popular_movies.model.Trailer;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ahmed on 5/4/2018.
 */

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.TrailerHolder> {

    private Context m_context;
    private List<Trailer> trailerList;

    public TrailerAdapter(Context m_context, List<Trailer> trailerList) {
        this.m_context = m_context;
        this.trailerList = trailerList;
    }


    @Override
    public TrailerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(m_context).inflate(R.layout.row_trailer, parent, false);
        TrailerHolder holder = new TrailerHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(TrailerHolder holder, final int position) {

        String trailer_Name = trailerList.get(position).getName();

        holder.trailerTitle.setText(trailer_Name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String youtube = "https://www.youtube.com/watch?v=" + trailerList.get(position).getKey();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(youtube));
                m_context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return trailerList.size();
    }

    public class TrailerHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.trailer_title)
        TextView trailerTitle;

        public TrailerHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
