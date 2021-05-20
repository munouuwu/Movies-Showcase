package com.dicoding.moviesshowcase.data.source.remote.api

import com.dicoding.moviesshowcase.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    private val httpClient = OkHttpClient.Builder().apply {

    }.build()


    private val retrofit: Retrofit.Builder by lazy {
        Retrofit.Builder().apply {
            client(httpClient)
            baseUrl(BuildConfig.API_KEY)
            addConverterFactory(GsonConverterFactory.create())
        }
    }


    val instance: ApiService by lazy {
        retrofit
            .build()
            .create(ApiService::class.java)
    }
}