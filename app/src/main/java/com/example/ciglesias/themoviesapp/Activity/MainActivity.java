package com.example.ciglesias.themoviesapp.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.ciglesias.themoviesapp.Adapter.FragmentTabAdapter;
import com.example.ciglesias.themoviesapp.Pojo.FragmentTab;
import com.example.ciglesias.themoviesapp.Presenter.MainPresenterImpl;
import com.example.ciglesias.themoviesapp.R;
import com.example.ciglesias.themoviesapp.View.MainView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainView {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
        MainPresenterImpl presenter = new MainPresenterImpl(this);
    }

    private void setViews() {
        tabLayout = findViewById(R.id.id_tab_main);
        viewPager = findViewById(R.id.id_viewpager);
        Toolbar toolbar = findViewById(R.id.id_toolbar);
        toolbar.setTitleTextColor(Color.WHITE);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getResources().getString(R.string.app_name));

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_search:
                Intent i = new Intent(this, SearchActivity.class);
                startActivity(i);
                break;
        }
        return true;
    }

    @Override
    public FragmentTabAdapter getFragmentAdapter(ArrayList<FragmentTab> listFragment) {
        return new FragmentTabAdapter(getSupportFragmentManager(), listFragment);
    }

    @Override
    public void setAdapterViewPager(FragmentTabAdapter adapter) {
        viewPager.setAdapter(adapter);
    }

    @Override
    public void setUpTabLayoutViewPager() {
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void setIconTab() {

    }
}
