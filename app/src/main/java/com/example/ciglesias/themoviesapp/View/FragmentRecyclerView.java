package com.example.ciglesias.themoviesapp.View;


import com.example.ciglesias.themoviesapp.Adapter.RecyclerAdapter;
import com.example.ciglesias.themoviesapp.Pojo.MovieListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ciglesias-pc on 07/07/2017.
 */

public interface FragmentRecyclerView {

    void updateListMovies(List<MovieListItem> listItems);

    void addListMovies(List<MovieListItem> listItems);

    void showLoading();

    void dismissLoading();

    void showErrorDialog();
}
