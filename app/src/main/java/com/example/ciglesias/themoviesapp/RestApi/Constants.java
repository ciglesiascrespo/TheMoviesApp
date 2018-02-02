package com.example.ciglesias.themoviesapp.RestApi;

/**
 * Created by Ciglesias on 31/01/2018.
 */

public class Constants {
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String BASE_URL_IMAGE_LIST = "https://image.tmdb.org/t/p/w300";
    public static final String BASE_URL_IMAGE_DETAIL = "https://image.tmdb.org/t/p/w500";
    public static final String KEY_GET_POPULAR = "movie/popular?";
    public static final String KEY_SEARCH = "search/movie?";

    public static final String KEY_GET_TOP_RATED = "movie/top_rated?";
    public static final String KEY_GET_DETAIL_MOVIE = "movie/{movie_id}?";
    public static final String API_KEY = "api_key=33b17ab57b26981fc9b738094617084d";
    public static final String LANGUAGE = "&language=es";


    public static final String GET_URL_POPULAR_MOVIE = KEY_GET_POPULAR + API_KEY + LANGUAGE ;

    public static final String GET_URL_TOP_RATED_MOVIE = KEY_GET_TOP_RATED + API_KEY + LANGUAGE ;
    public static final String GET_URL_DETAIL_MOVIE = KEY_GET_DETAIL_MOVIE + API_KEY + LANGUAGE ;
    public static final String GET_URL_SEARCH_MOVIE = KEY_SEARCH + API_KEY + LANGUAGE ;
}
