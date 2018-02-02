package com.example.ciglesias.themoviesapp.Pojo;

/**
 * Created by Ciglesias on 31/01/2018.
 */

public class MovieDetail {
    private String title;
    private String releaseDate;
    private String urlImg;
    private String runtime;
    private String overview;
    private String genres;

    public MovieDetail(String title, String releaseDate, String urlImg, String runtime, String overview, String genres) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.urlImg = urlImg;
        this.runtime = runtime + " min.";
        this.overview = overview;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getOverview() {
        return overview;
    }

    public String getGenres() {
        return genres;
    }
}
