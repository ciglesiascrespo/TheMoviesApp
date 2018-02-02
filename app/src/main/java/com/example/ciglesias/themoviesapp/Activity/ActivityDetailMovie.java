package com.example.ciglesias.themoviesapp.Activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ciglesias.themoviesapp.Presenter.DetailMoviePresenterImpl;
import com.example.ciglesias.themoviesapp.R;
import com.example.ciglesias.themoviesapp.RestApi.model.DetailMovieResponse;
import com.example.ciglesias.themoviesapp.View.DetailMovieView;
import com.squareup.picasso.Picasso;

public class ActivityDetailMovie extends AppCompatActivity implements DetailMovieView {
    public static final String KEY_EXTRA_ID_MOVIE = "idMovie";

    private ActionBar ab;
    private CollapsingToolbarLayout collapser;

    private TextView txtTitulo, txtSinopsis, txtFecha, txtTiempo, txtGenero;
    private ImageView imgMovie;
    private ProgressDialog loading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        txtTitulo = findViewById(R.id.id_txt_title_detail);
        txtSinopsis = findViewById(R.id.id_txt_overview);
        txtFecha = findViewById(R.id.id_txt_date_detail);
        txtTiempo = findViewById(R.id.id_txt_runtime);
        txtGenero = findViewById(R.id.id_txt_genres);
        imgMovie = findViewById(R.id.id_image_paralax);
        collapser = findViewById(R.id.collapser);

        int idMovie = getIntent().getIntExtra(KEY_EXTRA_ID_MOVIE, 0);
        setToolbar();
        setupLoading();
        DetailMoviePresenterImpl presenter = new DetailMoviePresenterImpl(this, idMovie);

    }

    private void setupLoading() {
        loading = new ProgressDialog(this);
        loading.setCancelable(false);
        loading.setMessage(getResources().getString(R.string.str_msj_loading_info_movie));
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
        builder.setMessage(getResources().getString(R.string.str_msj_alert_error_info_movie));
        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    private void setToolbar() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }


    @Override
    public void showInfo(DetailMovieResponse detail) {
        collapser.setTitle(detail.getTitle());
        txtTitulo.setText(detail.getTitle());
        Picasso.with(getApplicationContext())
                .load(detail.getPosterPath())
                .into(imgMovie);
        txtFecha.setText(detail.getReleaseDate());
        txtTiempo.setText(detail.getRuntime());
        txtGenero.setText(detail.getGenres());
        txtSinopsis.setText(detail.getOverview());

    }
}
