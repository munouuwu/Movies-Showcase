package com.dicoding.moviesshowcase.data.source.remote

import com.dicoding.moviesshowcase.data.source.remote.api.ApiConfig
import com.dicoding.moviesshowcase.data.source.remote.response.MvResponse
import com.dicoding.moviesshowcase.data.source.remote.response.TvResponse
import com.dicoding.moviesshowcase.repo.EspressoIdlingResource
import retrofit2.await

class RemoteDataSource {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    suspend fun getTopRatedMv(
        callback: LoadTopRatedMvCallback
    ) {
        EspressoIdlingResource.increment()
        ApiConfig.instance.getListMv().await().results?.let { listMovie ->
            callback.onMvListReceived(
                listMovie
            )
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getDetailMv(movieId: Int, callback: LoadDetailMvCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.instance.getDetailMv(movieId).await().let { movie ->
            callback.onMvDetailReceived(
                movie
            )
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTopRatedTv(callback: LoadTopRatedTvCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.instance.getListTv().await().results?.let { listTvShow ->
            callback.onTvListReceived(
                listTvShow
            )
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getDetailTv(tvShowId: Int, callback: LoadDetailTvCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.instance.getDetailTv(tvShowId).await().let { tvShow ->
            callback.onTvDetailReceived(
                tvShow
            )
            EspressoIdlingResource.decrement()
        }
    }

    interface LoadTopRatedMvCallback {
        fun onMvListReceived(response: List<MvResponse>)
    }

    interface LoadDetailMvCallback {
        fun onMvDetailReceived(response: MvResponse)
    }

    interface LoadTopRatedTvCallback {
        fun onTvListReceived(response: List<TvResponse>)
    }

    interface LoadDetailTvCallback {
        fun onTvDetailReceived(response: TvResponse)
    }
}