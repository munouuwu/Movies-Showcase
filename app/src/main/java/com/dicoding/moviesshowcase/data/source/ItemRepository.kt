package com.dicoding.moviesshowcase.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.moviesshowcase.data.Data
import com.dicoding.moviesshowcase.data.source.remote.RemoteDataSource
import com.dicoding.moviesshowcase.data.source.remote.response.MvResponse
import com.dicoding.moviesshowcase.data.source.remote.response.TvResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ItemRepository private constructor(private val remoteDataSource: RemoteDataSource) : ItemDataSource {
    companion object {
        @Volatile
        private var instance: ItemRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): ItemRepository =
            instance ?: synchronized(this) {
                instance ?: ItemRepository(remoteDataSource)
            }
    }

    override fun getTopRatedMv(): LiveData<List<Data>> {
        val result = MutableLiveData<List<Data>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getTopRatedMv(object : RemoteDataSource.LoadNowPlayingMoviesCallback{
                override fun onAllMoviesReceived(response: List<MvResponse>) {
                    val list = ArrayList<Data>()
                    for (resp in response){
                        val movie = Data(
                            resp.id,
                            resp.title,
                            resp.overview,
                            null,
                            resp.release_date,
                            resp.runtime,
                            resp.original_language,
                            resp.vote_average,
                            null,
                            null,
                            resp.poster_path
                        )
                        list.add(movie)
                    }
                    result.postValue(list)
                }
            })
        }

        return result
    }

    override fun getDetailMv(id: Int): LiveData<Data> {
        val result = MutableLiveData<Data>()
        CoroutineScope(IO).launch {
            remoteDataSource.getDetailMv(id, object : RemoteDataSource.LoadMovieDetailCallback{
                override fun onMovieDetailReceived(response: MvResponse) {
                    var genreString = ""
                    var i = 1

                    for(genre in response.genres){
                        if (i == response.genres.size){
                            genreString += genre.name
                        }else{
                            genreString += "${genre.name}, "
                        }

                        i++
                    }

                    val movie = Data(
                        response.id,
                        response.title,
                        response.overview,
                        genreString,
                        response.release_date,
                        response.runtime,
                        response.original_language,
                        response.vote_average,
                        null,
                        null,
                        response.poster_path
                    )

                    result.postValue(movie)
                }
            })
        }

        return result
    }

    override fun getTopRatedTv(): LiveData<List<Data>> {
        val result = MutableLiveData<List<Data>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getTopRatedTv(object : RemoteDataSource.LoadOnTheAirTvShowCallback{
                override fun onAllTvShowsReceived(response: List<TvResponse>) {
                    val list = ArrayList<Data>()
                    for (resp in response){
                        val tvShow = Data(
                            resp.id,
                            resp.name,
                            resp.overview,
                            null,
                            resp.first_air_date,
                            null,
                            resp.original_language,
                            resp.vote_average,
                            resp.number_of_episodes,
                            resp.number_of_seasons,
                            resp.poster_path
                        )
                        list.add(tvShow)
                    }

                    result.postValue(list)
                }
            })
        }

        return result
    }

    override fun getDetailTv(id: Int): LiveData<Data> {
        val result = MutableLiveData<Data>()
        CoroutineScope(IO).launch {
            remoteDataSource.getDetailTv(id, object : RemoteDataSource.LoadTvShowDetailCallback{
                override fun onTvShowDetailReceived(response: TvResponse) {
                    var genreString = ""
                    var i = 1

                    for(genre in response.genres){
                        if (i == response.genres.size){
                            genreString += genre.name
                        }else{
                            genreString += "${genre.name}, "
                        }

                        i++
                    }

                    val tvShow = Data(
                        response.id,
                        response.name,
                        response.overview,
                        genreString,
                        response.first_air_date,
                        null,
                        response.original_language,
                        response.vote_average,
                        response.number_of_episodes,
                        response.number_of_seasons,
                        response.poster_path
                    )

                    result.postValue(tvShow)
                }
            })
        }

        return result
    }
}