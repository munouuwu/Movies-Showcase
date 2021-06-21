package com.dicoding.moviesshowcase.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.dicoding.moviesshowcase.data.source.local.entity.MvEntity
import com.dicoding.moviesshowcase.data.source.local.entity.TvEntity

@Dao
interface ListDao {
    @Query("SELECT * FROM tb_favorite_mv")
    fun getListMv() : DataSource.Factory<Int, MvEntity>
    @Query("SELECT * FROM tb_favorite_tv")
    fun getListTv() : DataSource.Factory<Int, TvEntity>

    @Query("SELECT * FROM tb_favorite_mv WHERE isFavorite = 1")
    fun getFavoriteMv() : DataSource.Factory<Int, MvEntity>
    @Query("SELECT * FROM tb_favorite_tv WHERE isFavorite = 1")
    fun getFavoriteTv() : DataSource.Factory<Int, TvEntity>

    @Query("SELECT * FROM tb_favorite_mv WHERE mvId = :mvId")
    fun getDetailMv(mvId: Int) : LiveData<MvEntity>
    @Query("SELECT * FROM tb_favorite_tv WHERE tvId = :tvId")
    fun getDetailTv(tvId: Int) : LiveData<TvEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = MvEntity::class)
    fun insertMv(movies: List<MvEntity>)
    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = TvEntity::class)
    fun insertTv(tvShows: List<TvEntity>)

    @Update(entity = MvEntity::class)
    fun updateMv(movie : MvEntity)
    @Update(entity = TvEntity::class)
    fun updateTv(tvShows: TvEntity)
}