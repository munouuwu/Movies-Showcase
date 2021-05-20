package com.dicoding.moviesshowcase.data.source

import androidx.lifecycle.LiveData
import com.dicoding.moviesshowcase.data.Data

interface ItemDataSource {
    fun getListMv(): LiveData<List<Data>>

    fun getDetailMv(id: String): LiveData<LiveData<Data>>

    fun getListTv(): LiveData<List<Data>>

    fun getDetailTv(id: String): LiveData<LiveData<Data>>
}