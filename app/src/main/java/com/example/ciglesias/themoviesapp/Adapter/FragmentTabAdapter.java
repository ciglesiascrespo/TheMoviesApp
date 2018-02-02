package com.example.ciglesias.themoviesapp.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.example.ciglesias.themoviesapp.Pojo.FragmentTab;

import java.util.ArrayList;

/**
 * Created by Ciglesias-pc on 25/07/2017.
 */

public class FragmentTabAdapter extends FragmentPagerAdapter {
    ArrayList<FragmentTab> listFragments;

    public FragmentTabAdapter(FragmentManager fm, ArrayList<FragmentTab> listFragments) {
        super(fm);
        this.listFragments = listFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragments.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listFragments.get(position).getTitle();
    }

}
