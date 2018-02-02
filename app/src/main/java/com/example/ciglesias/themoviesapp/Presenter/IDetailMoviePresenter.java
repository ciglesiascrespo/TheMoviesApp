package com.example.ciglesias.themoviesapp.Presenter;

import com.example.ciglesias.themoviesapp.RestApi.model.DetailMovieResponse;

/**
 * Created by Ciglesias on 1/02/2018.
 */

public interface IDetailMoviePresenter {

    void onErrorLoadingInfoMovie();

    void showInfoMovie(DetailMovieResponse movie);

    void onCompleteInfo();
}
