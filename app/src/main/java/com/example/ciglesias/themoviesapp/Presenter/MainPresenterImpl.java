package com.example.ciglesias.themoviesapp.Presenter;



import com.example.ciglesias.themoviesapp.Fragment.PopularFragment;
import com.example.ciglesias.themoviesapp.Fragment.TopRatedFragment;
import com.example.ciglesias.themoviesapp.Pojo.FragmentTab;
import com.example.ciglesias.themoviesapp.View.MainView;

import java.util.ArrayList;

/**
 * Created by Ciglesias-pc on 25/07/2017.
 */

public class MainPresenterImpl {

    MainView mainView;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        initView();
    }


    public void initView() {
        mainView.setAdapterViewPager(mainView.getFragmentAdapter(getListFragment()));
        mainView.setUpTabLayoutViewPager();
        mainView.setIconTab();
    }

    private ArrayList<FragmentTab> getListFragment() {
        ArrayList<FragmentTab> list = new ArrayList<>();

        list.add(new FragmentTab(new PopularFragment(),"Popular"));
        list.add(new FragmentTab(new TopRatedFragment(),"Top Rated"));

        return list;
    }
}
