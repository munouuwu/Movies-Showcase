package com.dicoding.moviesshowcase.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.moviesshowcase.data.Data
import com.dicoding.moviesshowcase.data.source.remote.RemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ItemRepository private constructor(private val remoteDataSource: RemoteDataSource) : ItemDataSource {
    companion object {
        @Volatile
        private var instance: ItemRepository? = null
        fun getInstance(remoteData: RemoteDataSource): ItemRepository =
            instance ?: synchronized(this) {
                instance ?: ItemRepository(remoteData).apply { instance = this }
            }
    }

    override fun getListMv(): LiveData<List<Data>> {
        val list = MutableLiveData<List<Data>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getList(object : RemoteDataSource.LoadNowPlayingMoviesCallback{
                override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                    val movieList = ArrayList<DataModel>()
                    for (response in movieResponse){
                        val movie = DataModel(
                            response.id,
                            response.name,
                            response.desc,
                            response.poster,
                            response.img_preview
                        )
                        movieList.add(movie)
                    }
                    listMovieResult.postValue(movieList)
                }
            })
        }

        return listMovieResult
    }

    override fun getDetailMv(id: String): LiveData<LiveData<Data>> {
        TODO("Not yet implemented")
    }

    override fun getListTv(): LiveData<List<Data>> {
        TODO("Not yet implemented")
    }

    override fun getDetailTv(id: String): LiveData<LiveData<Data>> {
        TODO("Not yet implemented")
    }
}