package com.dicoding.moviesshowcase.data

import android.content.Context
import com.dicoding.moviesshowcase.data.source.ItemRepository
import com.dicoding.moviesshowcase.data.source.remote.RemoteDataSource

object Injection {
    fun provideItemRepository(context: Context): ItemRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return ItemRepository.getInstance(remoteDataSource)
    }
}