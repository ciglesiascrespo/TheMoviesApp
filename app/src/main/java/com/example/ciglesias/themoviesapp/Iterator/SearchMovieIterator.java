package com.example.ciglesias.themoviesapp.Iterator;

import com.example.ciglesias.themoviesapp.Presenter.IRecyclerFragmentPresenter;
import com.example.ciglesias.themoviesapp.RestApi.EndPoints;
import com.example.ciglesias.themoviesapp.RestApi.adapter.RestApiAdapter;
import com.example.ciglesias.themoviesapp.RestApi.model.ListMoviesResponse;

import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ciglesias on 31/01/2018.
 */

public class SearchMovieIterator {

    IRecyclerFragmentPresenter presenter;

    public SearchMovieIterator(IRecyclerFragmentPresenter presenter) {
        this.presenter = presenter;

    }


    public void search(String query, int page) {

        Retrofit retrofit = RestApiAdapter.provideRetrofit();


        retrofit.create(EndPoints.class).seacrhMovies(query, page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<ListMoviesResponse>() {
                               @Override
                               public void onCompleted() {
                                   presenter.onCompleteListMovies();
                               }

                               @Override
                               public void onError(Throwable e) {
                                   e.printStackTrace();
                                   presenter.onErrorLoadingMovies();

                               }

                               @Override
                               public void onNext(ListMoviesResponse listMoviesResponse) {
                                   presenter.showListMovies(listMoviesResponse.getResults());
                               }
                           }
                );
    }
}
