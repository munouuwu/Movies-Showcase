package com.dicoding.moviesshowcase.data.source.remote.api

import com.dicoding.moviesshowcase.data.source.remote.response.ListResponse
import com.dicoding.moviesshowcase.data.source.remote.response.MvResponse
import com.dicoding.moviesshowcase.data.source.remote.response.TvResponse
import com.dicoding.moviesshowcase.repo.Helper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/top_rated")
    fun getListMv(
        @Query("api_key") apiKey: String = Helper.API_KEY
    ) : Call<ListResponse<MvResponse>>

    @GET("movie/{movie_id}")
    fun getDetailMv(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String = Helper.API_KEY
    ) : Call<MvResponse>

    @GET("tv/top_rated")
    fun getListTv(
        @Query("api_key") apiKey: String = Helper.API_KEY
    ) : Call<ListResponse<TvResponse>>

    @GET("tv/{tv_id}")
    fun getDetailTv(
        @Path("tv_id") id: Int,
        @Query("api_key") apiKey: String = Helper.API_KEY
    ) : Call<TvResponse>
}