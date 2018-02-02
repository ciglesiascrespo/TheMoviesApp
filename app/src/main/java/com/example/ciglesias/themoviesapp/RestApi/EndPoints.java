package com.example.ciglesias.themoviesapp.RestApi;

import com.example.ciglesias.themoviesapp.RestApi.model.DetailMovieResponse;
import com.example.ciglesias.themoviesapp.RestApi.model.ListMoviesResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Ciglesias on 31/01/2018.
 */

public interface EndPoints {
    @GET(Constants.GET_URL_POPULAR_MOVIE)
    Observable<ListMoviesResponse> getPopularMovies(@Query("page") int page);

    @GET(Constants.GET_URL_TOP_RATED_MOVIE)
    Observable<ListMoviesResponse> getTopRatedMovies(@Query("page") int page);

    @GET(Constants.GET_URL_SEARCH_MOVIE)
    Observable<ListMoviesResponse> seacrhMovies(@Query("query") String query, @Query("page") int page);

    @GET(Constants.GET_URL_DETAIL_MOVIE)
    Observable<DetailMovieResponse> getDetailMovie(@Path("movie_id") int id);
}
