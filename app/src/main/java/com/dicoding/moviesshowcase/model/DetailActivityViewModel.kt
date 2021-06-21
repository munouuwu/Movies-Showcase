package com.dicoding.moviesshowcase.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.moviesshowcase.data.source.ItemRepository
import com.dicoding.moviesshowcase.data.source.local.entity.MvEntity
import com.dicoding.moviesshowcase.data.source.local.entity.TvEntity
import com.dicoding.moviesshowcase.vo.Resource

class DetailActivityViewModel constructor(private val itemRepository: ItemRepository) : ViewModel() {
    private var mvId : Int = 0
    private var tvId : Int = 0

    fun getMvById() : LiveData<Resource<MvEntity>> = itemRepository.getDetailMv(mvId)
    fun getTvById() : LiveData<Resource<TvEntity>> = itemRepository.getDetailTv(tvId)

    fun setSelectedMv(mvId: Int) {
        this.mvId = mvId
    }

    fun setSelectedTv(tvId: Int) {
        this.tvId = tvId
    }

    fun setFavMv(mvEntity: MvEntity) {
        val state = !mvEntity.isFavorite
        itemRepository.setFavoriteMv(mvEntity, state)
    }

    fun setFavTv(tvEntity: TvEntity) {
        val state = !tvEntity.isFavorite
        itemRepository.setFavoriteTv(tvEntity, state)
    }
}