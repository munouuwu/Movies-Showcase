package com.dicoding.moviesshowcase.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.moviesshowcase.data.Data
import com.dicoding.moviesshowcase.data.source.ItemRepository
import com.dicoding.moviesshowcase.data.source.remote.RemoteDataSource

class ListDataViewModel constructor(private val itemRepository: ItemRepository) : ViewModel() {
    fun getMovies() : LiveData<List<Data>> = itemRepository.getTopRatedMv()

    fun getTvs() : LiveData<List<Data>> = itemRepository.getTopRatedTv()
}