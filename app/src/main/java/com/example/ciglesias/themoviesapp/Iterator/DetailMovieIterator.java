package com.example.ciglesias.themoviesapp.Iterator;

import com.example.ciglesias.themoviesapp.Pojo.MovieDetail;
import com.example.ciglesias.themoviesapp.Presenter.IDetailMoviePresenter;
import com.example.ciglesias.themoviesapp.RestApi.EndPoints;
import com.example.ciglesias.themoviesapp.RestApi.adapter.RestApiAdapter;
import com.example.ciglesias.themoviesapp.RestApi.model.DetailMovieResponse;
import com.example.ciglesias.themoviesapp.RestApi.model.ListMoviesResponse;

import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ciglesias on 31/01/2018.
 */

public class DetailMovieIterator {
    MovieDetail detail;
    IDetailMoviePresenter presenter;

    public DetailMovieIterator(IDetailMoviePresenter presenter) {
        this.presenter = presenter;

    }


    public void getDetail(int id) {

        Retrofit retrofit = RestApiAdapter.provideRetrofit();


        retrofit.create(EndPoints.class).getDetailMovie(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<DetailMovieResponse>() {
                               @Override
                               public void onCompleted() {
                                   presenter.onCompleteInfo();
                               }

                               @Override
                               public void onError(Throwable e) {
                                   e.printStackTrace();
                                   presenter.onErrorLoadingInfoMovie();

                               }

                               @Override
                               public void onNext(DetailMovieResponse detailMovieResponse) {
                                   presenter.showInfoMovie(detailMovieResponse);
                               }
                           }
                );
    }
}
