package com.example.ciglesias.themoviesapp.Activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.ciglesias.themoviesapp.Adapter.RecyclerAdapter;
import com.example.ciglesias.themoviesapp.ItemDecoration.SpacingDecoration;
import com.example.ciglesias.themoviesapp.Pojo.MovieListItem;
import com.example.ciglesias.themoviesapp.Presenter.SearchPresenterImpl;
import com.example.ciglesias.themoviesapp.R;
import com.example.ciglesias.themoviesapp.View.FragmentRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements FragmentRecyclerView {
    SearchPresenterImpl presenter;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    private ProgressDialog loading;

    private int page = 1;
    public String queryS = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.id_recyclerview_list_items);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        presenter = new SearchPresenterImpl(this);

        generarGridLayout();
        initAdapterRV();
        setupLoading();

    }

    private void setupLoading() {
        loading = new ProgressDialog(this);
        loading.setCancelable(false);
        loading.setMessage(getResources().getString(R.string.str_msj_loading_movies));
    }

    public void generarGridLayout() {
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
        recyclerView.addItemDecoration(new SpacingDecoration(spacingInPixels));
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (gridLayoutManager.findLastCompletelyVisibleItemPosition() == (gridLayoutManager.getItemCount() - 1)) {
                    page++;
                    presenter.searchMovie(queryS, page);
                }
            }
        });
    }


    public void initAdapterRV() {
        ArrayList<MovieListItem> listItems = new ArrayList<>();
        adapter = new RecyclerAdapter(listItems, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setQueryHint(getText(R.string.action_search));
        searchView.setIconified(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                page = 1;
                queryS = query;
                presenter.searchMovie(query, page);
                searchView.setQuery("", false);
                searchView.setIconified(true);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return true;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void updateListMovies(List<MovieListItem> listItems) {
        adapter.updateListMovies(listItems);

    }

    @Override
    public void addListMovies(List<MovieListItem> listItems) {
        adapter.addListMovies(listItems);
    }

    @Override
    public void showLoading() {
        if (loading != null && !loading.isShowing()) {
            loading.show();
        }
    }

    @Override
    public void dismissLoading() {
        if (loading != null && loading.isShowing()) {
            loading.dismiss();
        }
    }

    @Override
    public void showErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.myDialog);

        builder.setTitle(getResources().getString(R.string.str_title_alert_error_movies));
        builder.setMessage(getResources().getString(R.string.str_msj_alert_error_movies));
        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
