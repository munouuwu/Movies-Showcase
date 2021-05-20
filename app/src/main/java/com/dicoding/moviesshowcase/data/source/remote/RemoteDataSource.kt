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
        callback: LoadNowPlayingMoviesCallback
    ) {
        EspressoIdlingResource.increment()
        ApiConfig.instance.getListMv().await().results?.let { listMovie ->
            callback.onAllMoviesReceived(
                listMovie
            )
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getDetailMv(movieId: Int, callback: LoadMovieDetailCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.instance.getDetailMv(movieId).await().let { movie ->
            callback.onMovieDetailReceived(
                movie
            )
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTopRatedTv(callback: LoadOnTheAirTvShowCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.instance.getListTv().await().results?.let { listTvShow ->
            callback.onAllTvShowsReceived(
                listTvShow
            )
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getDetailTv(tvShowId: Int, callback: LoadTvShowDetailCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.instance.getDetailTv(tvShowId).await().let { tvShow ->
            callback.onTvShowDetailReceived(
                tvShow
            )
            EspressoIdlingResource.decrement()
        }
    }

    interface LoadNowPlayingMoviesCallback {
        fun onAllMoviesReceived(response: List<MvResponse>)
    }

    interface LoadMovieDetailCallback {
        fun onMovieDetailReceived(response: MvResponse)
    }

    interface LoadOnTheAirTvShowCallback {
        fun onAllTvShowsReceived(response: List<TvResponse>)
    }

    interface LoadTvShowDetailCallback {
        fun onTvShowDetailReceived(response: TvResponse)
    }
}