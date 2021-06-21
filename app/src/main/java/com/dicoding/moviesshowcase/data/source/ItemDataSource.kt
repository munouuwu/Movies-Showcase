package com.dicoding.moviesshowcase.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dicoding.moviesshowcase.data.source.local.entity.MvEntity
import com.dicoding.moviesshowcase.data.source.local.entity.TvEntity
import com.dicoding.moviesshowcase.vo.Resource

interface ItemDataSource {
    fun getTopRatedMv(): LiveData<Resource<PagedList<MvEntity>>>
    fun getFavoriteMv(): LiveData<PagedList<MvEntity>>
    fun getDetailMv(id: Int): LiveData<Resource<MvEntity>>

    fun getTopRatedTv(): LiveData<Resource<PagedList<TvEntity>>>
    fun getFavoriteTv(): LiveData<PagedList<TvEntity>>
    fun getDetailTv(id: Int): LiveData<Resource<TvEntity>>

    fun setFavoriteMv(mv: MvEntity, state: Boolean)
    fun setFavoriteTv(tv: TvEntity, state: Boolean)
}