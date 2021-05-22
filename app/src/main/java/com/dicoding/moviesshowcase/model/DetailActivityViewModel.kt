package com.dicoding.moviesshowcase.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.moviesshowcase.data.Data
import com.dicoding.moviesshowcase.data.source.ItemRepository
import com.dicoding.moviesshowcase.data.source.remote.RemoteDataSource

class DetailActivityViewModel constructor(private val itemRepository: ItemRepository) : ViewModel() {
    private var mvId : Int = 0
    private var tvId : Int = 0

    fun getMvById() : LiveData<Data> = itemRepository.getDetailMv(mvId)
    fun getTvById() : LiveData<Data> = itemRepository.getDetailTv(tvId)

    fun setSelectedMv(mvId: Int) {
        this.mvId = mvId
    }

    fun setSelectedTv(tvId: Int) {
        this.tvId = tvId
    }
}