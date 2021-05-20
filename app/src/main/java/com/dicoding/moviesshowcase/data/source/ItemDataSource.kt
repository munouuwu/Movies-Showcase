package com.dicoding.moviesshowcase.data.source

import androidx.lifecycle.LiveData
import com.dicoding.moviesshowcase.data.Data

interface ItemDataSource {
    fun getTopRatedMv(): LiveData<List<Data>>

    fun getDetailMv(id: Int): LiveData<Data>

    fun getTopRatedTv(): LiveData<List<Data>>

    fun getDetailTv(id: Int): LiveData<Data>
}