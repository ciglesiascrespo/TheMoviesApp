package com.example.ciglesias.themoviesapp.Presenter;


import com.example.ciglesias.themoviesapp.Iterator.PopularIterator;
import com.example.ciglesias.themoviesapp.Pojo.MovieListItem;
import com.example.ciglesias.themoviesapp.View.FragmentRecyclerView;

import java.util.List;

/**
 * Created by Ciglesias on 27/12/2017.
 */

public class FragmentPopularPresenterImpl implements IRecyclerFragmentPresenter {
    private PopularIterator iterator;
    private FragmentRecyclerView fragmentRecyclerView;
    private int page;

    public FragmentPopularPresenterImpl(FragmentRecyclerView fragmentRecyclerView) {
        iterator = new PopularIterator(this);
        this.fragmentRecyclerView = fragmentRecyclerView;

    }

    public void getListItems(int page) {
        this.page = page;
        fragmentRecyclerView.showLoading();
        iterator.getListPopularMovies(page);
    }


    @Override
    public void onErrorLoadingMovies() {
        fragmentRecyclerView.dismissLoading();
        fragmentRecyclerView.showErrorDialog();
    }

    @Override
    public void showListMovies(List<MovieListItem> movies) {
        if (page == 1) {
            fragmentRecyclerView.updateListMovies(movies);
        } else {
            fragmentRecyclerView.addListMovies(movies);
        }

    }

    @Override
    public void onCompleteListMovies() {
        fragmentRecyclerView.dismissLoading();

    }
}
