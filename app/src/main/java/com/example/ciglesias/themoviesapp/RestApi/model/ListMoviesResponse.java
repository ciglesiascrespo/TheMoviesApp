package com.example.ciglesias.themoviesapp.RestApi.model;

import com.example.ciglesias.themoviesapp.Pojo.MovieListItem;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ciglesias on 31/01/2018.
 */

public class ListMoviesResponse {
    @SerializedName("results")
    @Expose
    private List<MovieListItem> results = null;

    public List<MovieListItem> getResults() {
        return results;
    }

    public void setResults(List<MovieListItem> results) {
        this.results = results;
    }
}
