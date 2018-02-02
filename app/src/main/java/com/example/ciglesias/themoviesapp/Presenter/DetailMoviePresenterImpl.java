package com.example.ciglesias.themoviesapp.Presenter;

import com.example.ciglesias.themoviesapp.Iterator.DetailMovieIterator;
import com.example.ciglesias.themoviesapp.Pojo.MovieDetail;
import com.example.ciglesias.themoviesapp.RestApi.model.DetailMovieResponse;
import com.example.ciglesias.themoviesapp.View.DetailMovieView;

/**
 * Created by Ciglesias on 31/01/2018.
 */

public class DetailMoviePresenterImpl implements IDetailMoviePresenter {
    DetailMovieView view;
    DetailMovieIterator iterator;

    public DetailMoviePresenterImpl(DetailMovieView view, int id) {
        this.view = view;
        iterator = new DetailMovieIterator(this);
        view.showLoading();
        iterator.getDetail(id);
    }

    @Override
    public void onErrorLoadingInfoMovie() {
        view.dismissLoading();
        view.showErrorDialog();
    }

    @Override
    public void showInfoMovie(DetailMovieResponse movie) {
        view.showInfo(movie);
    }


    @Override
    public void onCompleteInfo() {
        view.dismissLoading();
    }
}
