package com.example.ciglesias.themoviesapp.Pojo;

import android.support.v4.app.Fragment;

/**
 * Created by Ciglesias-pc on 25/07/2017.
 */

public class FragmentTab {
    private Fragment fragment;
    private String title;


    public FragmentTab(Fragment fragment, String title) {
        this.fragment = fragment;
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public String getTitle() {
        return title;
    }
}
