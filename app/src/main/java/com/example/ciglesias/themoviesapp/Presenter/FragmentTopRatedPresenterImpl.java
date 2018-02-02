package com.example.ciglesias.themoviesapp.Presenter;


import com.example.ciglesias.themoviesapp.Iterator.TopRatedIterator;
import com.example.ciglesias.themoviesapp.Pojo.MovieListItem;
import com.example.ciglesias.themoviesapp.View.FragmentRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ciglesias on 27/12/2017.
 */

public class FragmentTopRatedPresenterImpl implements IRecyclerFragmentPresenter {
    private TopRatedIterator iterator;
    private ArrayList<MovieListItem> listItems;
    private FragmentRecyclerView fragmentRecyclerView;
    private int page;

    public FragmentTopRatedPresenterImpl(FragmentRecyclerView fragmentRecyclerView) {
        iterator = new TopRatedIterator(this);
        this.fragmentRecyclerView = fragmentRecyclerView;
    }

    public void getListItems(int page) {
        this.page = page;
        fragmentRecyclerView.showLoading();
        iterator.getListTopRatedMovies(page);
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
