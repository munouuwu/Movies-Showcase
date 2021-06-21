package com.dicoding.moviesshowcase.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dicoding.moviesshowcase.data.source.remote.RemoteDataSource
import com.dicoding.moviesshowcase.data.source.remote.response.MvResponse
import com.dicoding.moviesshowcase.data.source.remote.response.TvResponse
import com.dicoding.moviesshowcase.data.source.remote.vo.ApiResponse
import com.dicoding.moviesshowcase.data.source.local.LocalDataSource
import com.dicoding.moviesshowcase.data.source.local.NetworkBoundResource
import com.dicoding.moviesshowcase.data.source.local.entity.MvEntity
import com.dicoding.moviesshowcase.data.source.local.entity.TvEntity
import com.dicoding.moviesshowcase.utils.AppExecutors
import com.dicoding.moviesshowcase.vo.Resource

class ItemRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ItemDataSource {

    companion object {
        @Volatile
        private var instance: ItemRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource, localDataSource: LocalDataSource, appExecutors: AppExecutors): ItemRepository =
            instance ?: synchronized(this) {
                instance ?: ItemRepository(remoteDataSource, localDataSource, appExecutors)
            }
    }

    override fun getTopRatedMv(): LiveData<Resource<PagedList<MvEntity>>> {
        return object : NetworkBoundResource<PagedList<MvEntity>, List<MvResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MvEntity>> {
                val config = PagedList.Config.Builder().apply {
                    setEnablePlaceholders(false)
                    setInitialLoadSizeHint(4)
                    setPageSize(4)
                }.build()

                return LivePagedListBuilder(localDataSource.getListMv(), config).build()
            }

            override fun shouldFetch(data: PagedList<MvEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MvResponse>>> =
                remoteDataSource.getTopRatedMv()

            public override fun saveCallResult(data: List<MvResponse>) {
                val list = ArrayList<MvEntity>()
                for (item in data) {
                    val movie = MvEntity(
                        item.id,
                        item.id,
                        item.title,
                        item.overview,
                        item.release_date,
                        null,
                        null,
                        item.original_language,
                        item.vote_average,
                        item.poster_path
                    )
                    list.add(movie)
                }

                localDataSource.insertMv(list)
            }

        }.asLiveData()
    }

    override fun getDetailMv(id: Int): LiveData<Resource<MvEntity>> {
        return object : NetworkBoundResource<MvEntity, MvResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<MvEntity> = localDataSource.getDetailMv(id)

            override fun shouldFetch(data: MvEntity?): Boolean =
                data != null && data.runtime == null && data.genres == null

            override fun createCall(): LiveData<ApiResponse<MvResponse>> =
                remoteDataSource.getDetailMv(id)

            override fun saveCallResult(data: MvResponse) {
                var genreString = ""
                var i = 1

                for(genre in data.genres){
                    genreString += if (i == data.genres.size){
                        genre.name
                    }else{
                        "${genre.name}, "
                    }

                    i++
                }

                val movie = MvEntity(
                    data.id,
                    data.id,
                    data.title,
                    data.overview,
                    data.release_date,
                    data.runtime,
                    genreString,
                    data.original_language,
                    data.vote_average,
                    data.poster_path
                )
                localDataSource.updateMv(movie, false)
            }
        }.asLiveData()
    }

    override fun getTopRatedTv(): LiveData<Resource<PagedList<TvEntity>>> {
        return object : NetworkBoundResource<PagedList<TvEntity>, List<TvResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<TvEntity>> {
                val config = PagedList.Config.Builder().apply {
                    setEnablePlaceholders(false)
                    setInitialLoadSizeHint(4)
                    setPageSize(4)
                }.build()
                return LivePagedListBuilder(localDataSource.getListTv(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvEntity>?): Boolean =
                data == null || data.isEmpty()


            public override fun createCall(): LiveData<ApiResponse<List<TvResponse>>> =
                remoteDataSource.getTopRatedTv()

            public override fun saveCallResult(data: List<TvResponse>) {
                val list = ArrayList<TvEntity>()
                for (item in data) {
                    val movie = TvEntity(
                        item.id,
                        item.id,
                        item.name,
                        item.overview,
                        item.first_air_date,
                        null,
                        null,
                        null,
                        item.original_language,
                        item.vote_average,
                        item.poster_path
                    )
                    list.add(movie)
                }

                localDataSource.insertTv(list)
            }

        }.asLiveData()
    }

    override fun getDetailTv(id: Int): LiveData<Resource<TvEntity>> {
        return object : NetworkBoundResource<TvEntity, TvResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<TvEntity> = localDataSource.getDetailTv(id)

            override fun shouldFetch(data: TvEntity?): Boolean =
                data != null && data.episodes == null && data.episodes == null && data.genres == null

            override fun createCall(): LiveData<ApiResponse<TvResponse>> =
                remoteDataSource.getDetailTv(id)

            override fun saveCallResult(data: TvResponse) {

                var genreString = ""
                var i = 1

                for(genre in data.genres){
                    genreString += if (i == data.genres.size){
                        genre.name
                    }else{
                        "${genre.name}, "
                    }

                    i++
                }

                val tvShow = TvEntity(
                    data.id,
                    data.id,
                    data.name,
                    data.overview,
                    data.first_air_date,
                    genreString,
                    data.number_of_episodes,
                    data.number_of_seasons,
                    data.original_language,
                    data.vote_average,
                    data.poster_path
                )
                localDataSource.updateTv(tvShow, false)
            }
        }.asLiveData()
    }


    override fun getFavoriteMv(): LiveData<PagedList<MvEntity>> {
        val config = PagedList.Config.Builder().apply {
            setEnablePlaceholders(false)
            setInitialLoadSizeHint(4)
            setPageSize(4)
        }.build()
        return LivePagedListBuilder(localDataSource.getFavoriteMv(), config).build()
    }

    override fun getFavoriteTv(): LiveData<PagedList<TvEntity>> {
        val config = PagedList.Config.Builder().apply {
            setEnablePlaceholders(false)
            setInitialLoadSizeHint(4)
            setPageSize(4)
        }.build()
        return LivePagedListBuilder(localDataSource.getFavoriteTv(), config).build()
    }

    override fun setFavoriteMv(mv: MvEntity, state: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.updateMv(mv, state)
        }
    }

    override fun setFavoriteTv(tv: TvEntity, state: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.updateTv(tv, state)
        }
    }
}