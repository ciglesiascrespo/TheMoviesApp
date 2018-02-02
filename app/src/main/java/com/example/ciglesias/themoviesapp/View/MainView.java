package com.example.ciglesias.themoviesapp.View;


import com.example.ciglesias.themoviesapp.Adapter.FragmentTabAdapter;
import com.example.ciglesias.themoviesapp.Pojo.FragmentTab;

import java.util.ArrayList;

/**
 * Created by Ciglesias-pc on 25/07/2017.
 */

public interface MainView {
    FragmentTabAdapter getFragmentAdapter(ArrayList<FragmentTab> listFragment);

    void setAdapterViewPager(FragmentTabAdapter adapter);

    void setUpTabLayoutViewPager();

    void setIconTab();
}
