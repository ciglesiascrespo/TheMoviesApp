package com.example.ciglesias.themoviesapp.Fragment;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ciglesias.themoviesapp.Adapter.RecyclerAdapter;
import com.example.ciglesias.themoviesapp.ItemDecoration.SpacingDecoration;
import com.example.ciglesias.themoviesapp.Pojo.MovieListItem;
import com.example.ciglesias.themoviesapp.Presenter.FragmentPopularPresenterImpl;
import com.example.ciglesias.themoviesapp.R;
import com.example.ciglesias.themoviesapp.View.FragmentRecyclerView;

import java.util.ArrayList;
import java.util.List;


public class PopularFragment extends Fragment implements FragmentRecyclerView {
    RecyclerView recyclerView;
    FragmentPopularPresenterImpl presenter;
    RecyclerAdapter adapter;
    private ProgressDialog loading;

    private int page = 1;

    public PopularFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = view.findViewById(R.id.id_recyclerview_list_items);
        presenter = new FragmentPopularPresenterImpl(this);
        generarGridLayout();
        initAdapterRV();
        setupLoading();
        presenter.getListItems(page);
        return view;
    }

    @Override
    public void onResume() {

        super.onResume();
    }

    private void setupLoading() {
        loading = new ProgressDialog(getContext());
        loading.setCancelable(false);
        loading.setMessage(getResources().getString(R.string.str_msj_loading_movies));
    }

    public void generarGridLayout() {
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
        recyclerView.addItemDecoration(new SpacingDecoration(spacingInPixels));
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (gridLayoutManager.findLastCompletelyVisibleItemPosition() == (gridLayoutManager.getItemCount() - 1)) {
                    page++;
                    presenter.getListItems(page);
                }
            }
        });
    }


    public void initAdapterRV() {
        ArrayList<MovieListItem> listItems = new ArrayList<>();
        adapter = new RecyclerAdapter(listItems, getContext());
        recyclerView.setAdapter(adapter);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), R.style.myDialog);

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
