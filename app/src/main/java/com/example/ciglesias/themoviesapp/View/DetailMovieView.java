package com.example.ciglesias.themoviesapp.View;

import com.example.ciglesias.themoviesapp.Pojo.MovieDetail;
import com.example.ciglesias.themoviesapp.RestApi.model.DetailMovieResponse;

/**
 * Created by Ciglesias on 31/01/2018.
 */

public interface DetailMovieView {
    void showInfo(DetailMovieResponse detail);
    void showLoading();
    void dismissLoading();
    void showErrorDialog();
}
