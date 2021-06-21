package com.dicoding.moviesshowcase.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.moviesshowcase.data.source.ItemRepository
import com.dicoding.moviesshowcase.data.source.local.entity.MvEntity
import com.dicoding.moviesshowcase.data.source.local.entity.TvEntity
import com.dicoding.moviesshowcase.vo.Resource

class ListDataViewModel constructor(private val itemRepository: ItemRepository) : ViewModel() {

    fun getMovies() : LiveData<Resource<PagedList<MvEntity>>> = itemRepository.getTopRatedMv()

    fun getTvs() : LiveData<Resource<PagedList<TvEntity>>> = itemRepository.getTopRatedTv()

    fun getFavoriteMv(): LiveData<PagedList<MvEntity>> = itemRepository.getFavoriteMv()

    fun getFavoriteTv(): LiveData<PagedList<TvEntity>> = itemRepository.getFavoriteTv()
}