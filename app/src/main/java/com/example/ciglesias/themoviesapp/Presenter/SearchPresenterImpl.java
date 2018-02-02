package com.example.ciglesias.themoviesapp.Presenter;

import com.example.ciglesias.themoviesapp.Iterator.SearchMovieIterator;
import com.example.ciglesias.themoviesapp.Pojo.MovieListItem;
import com.example.ciglesias.themoviesapp.View.FragmentRecyclerView;

import java.util.List;

/**
 * Created by Ciglesias on 1/02/2018.
 */

public class SearchPresenterImpl implements IRecyclerFragmentPresenter {
    FragmentRecyclerView view;
    SearchMovieIterator iterator;
    private int page;

    public SearchPresenterImpl(FragmentRecyclerView view) {
        this.view = view;
        iterator = new SearchMovieIterator(this);
    }

    public void searchMovie(String query, int page) {
        this.page = page;
        view.showLoading();
        iterator.search(query, page);
    }


    @Override
    public void onErrorLoadingMovies() {
        view.dismissLoading();

        view.showErrorDialog();
    }

    @Override
    public void showListMovies(List<MovieListItem> movie) {
        if (page == 1) {
            view.updateListMovies(movie);
        } else {
            view.addListMovies(movie);
        }

    }

    @Override
    public void onCompleteListMovies() {
        view.dismissLoading();
    }
}
