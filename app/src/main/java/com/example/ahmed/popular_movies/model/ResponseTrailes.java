package com.example.ahmed.popular_movies.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ahmed on 5/4/2018.
 */

public class ResponseTrailes {

    private String id;

    @SerializedName("results")
    private List<Trailer> trailes;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public List<Trailer> getTrailes() {
        return trailes;
    }

    public void setTrailes(List<Trailer> trailes) {
        this.trailes = trailes;
    }
}
