package com.example.ciglesias.themoviesapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ciglesias.themoviesapp.Activity.ActivityDetailMovie;
import com.example.ciglesias.themoviesapp.Pojo.MovieListItem;
import com.example.ciglesias.themoviesapp.R;
import com.example.ciglesias.themoviesapp.RestApi.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Ciglesias on 27/12/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MovieViewHolder> {
    List<MovieListItem> listItems;

    Context context;

    public RecyclerAdapter(List<MovieListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;

    }

    public void addListMovies(List<MovieListItem> listItems) {
        this.listItems.addAll(listItems);
        notifyDataSetChanged();
    }

    public void updateListMovies(List<MovieListItem> listItems) {
        this.listItems = listItems;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new RecyclerAdapter.MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MovieViewHolder holder, final int position) {
        final MovieListItem itemList = listItems.get(position);

        holder.txtNombre.setText(itemList.getTitle());
        holder.txtFehca.setText(itemList.getReleaseDate());

        Picasso.with(context)
                .load(Constants.BASE_URL_IMAGE_LIST + itemList.getPosterPath())
                .placeholder(R.drawable.place_holder)
                .into(holder.imgFoto);
        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ActivityDetailMovie.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra(ActivityDetailMovie.KEY_EXTRA_ID_MOVIE, itemList.getId());
                context.startActivity(i);
                // goToDetailItem(itemGuia, holder.imgFoto,holder.txtNombre);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView txtNombre;
        private TextView txtFehca;


        private View v;

        public MovieViewHolder(View itemView) {
            super(itemView);

            imgFoto = itemView.findViewById(R.id.id_img_movie_list);
            txtNombre = itemView.findViewById(R.id.id_txt_title);
            txtFehca = itemView.findViewById(R.id.id_txt_date);


            v = itemView;
        }
    }
}
