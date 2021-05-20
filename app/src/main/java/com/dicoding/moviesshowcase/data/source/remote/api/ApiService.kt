package com.dicoding.moviesshowcase.data.source.remote.api

import com.dicoding.moviesshowcase.BuildConfig
import com.dicoding.moviesshowcase.data.source.remote.response.ListResponse
import com.dicoding.moviesshowcase.data.source.remote.response.MvResponse
import com.dicoding.moviesshowcase.data.source.remote.response.TvResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/now_playing")
    fun getListMv(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ) : Call<ListResponse<MvResponse>>

    @GET("movie/{movie_id}")
    fun getDetailMv(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ) : Call<MvResponse>

    @GET("tv/on_the_air")
    fun getListTv(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ) : Call<ListResponse<TvResponse>>

    @GET("tv/{tv_id}")
    fun getDetailTv(
        @Path("tv_id") tvShowId: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ) : Call<TvResponse>
}