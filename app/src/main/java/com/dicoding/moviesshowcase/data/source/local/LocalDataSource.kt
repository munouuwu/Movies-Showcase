package com.dicoding.moviesshowcase.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dicoding.moviesshowcase.data.source.local.entity.MvEntity
import com.dicoding.moviesshowcase.data.source.local.entity.TvEntity
import com.dicoding.moviesshowcase.data.source.local.room.ListDao

class LocalDataSource constructor(private val listDao: ListDao) {

    companion object {

        private var INSTANCE: LocalDataSource? = null

        fun getInstance(listDao : ListDao): LocalDataSource {
            if (INSTANCE == null) {
                INSTANCE = LocalDataSource(listDao)
            }
            return INSTANCE as LocalDataSource
        }
    }

    fun getListMv() : DataSource.Factory<Int, MvEntity> = listDao.getListMv()
    fun getListTv() : DataSource.Factory<Int, TvEntity> = listDao.getListTv()

    fun getFavoriteMv() : DataSource.Factory<Int, MvEntity> = listDao.getFavoriteMv()
    fun getFavoriteTv() : DataSource.Factory<Int, TvEntity> = listDao.getFavoriteTv()

    fun getDetailMv(movieId: Int) : LiveData<MvEntity> = listDao.getDetailMv(movieId)
    fun getDetailTv(tvShowId: Int) : LiveData<TvEntity> = listDao.getDetailTv(tvShowId)

    fun insertMv(movies: List<MvEntity>) = listDao.insertMv(movies)
    fun insertTv(tvShows: List<TvEntity>) = listDao.insertTv(tvShows)

    fun updateMv(mv: MvEntity, newState: Boolean) {
        mv.isFavorite = newState
        listDao.updateMv(mv)
    }
    fun updateTv(tv: TvEntity, newState: Boolean) {
        tv.isFavorite = newState
        listDao.updateTv(tv)
    }
}