package com.example.ciglesias.themoviesapp.Presenter;

import com.example.ciglesias.themoviesapp.Pojo.MovieListItem;

import java.util.List;

/**
 * Created by Ciglesias-pc on 07/07/2017.
 */

public interface IRecyclerFragmentPresenter {

    void onErrorLoadingMovies();

    void showListMovies(List<MovieListItem> movie);

    void onCompleteListMovies();
}
