package com.example.ciglesias.themoviesapp.RestApi.model;

import com.example.ciglesias.themoviesapp.RestApi.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ciglesias on 1/02/2018.
 */

public class DetailMovieResponse {
    @SerializedName("genres")
    @Expose
    private List<Genre> genres = null;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("runtime")
    @Expose
    private Integer runtime;
    @SerializedName("title")
    @Expose
    private String title;

    public String getGenres() {
        String genresStr = "";
        for (int i = 0; i < genres.size(); i++) {
            genresStr += genres.get(i).getName() + ((i == genres.size() - 1) ? "" : ",");
        }
        return genresStr;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return Constants.BASE_URL_IMAGE_DETAIL + posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRuntime() {
        return runtime + " min.";
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
