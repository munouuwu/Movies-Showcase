package com.dicoding.moviesshowcase.data

import android.content.Context
import com.dicoding.moviesshowcase.data.source.ItemRepository
import com.dicoding.moviesshowcase.data.source.remote.RemoteDataSource
import com.dicoding.moviesshowcase.data.source.local.LocalDataSource
import com.dicoding.moviesshowcase.data.source.local.room.ListDatabase
import com.dicoding.moviesshowcase.utils.AppExecutors

object Injection {
    fun provideItemRepository(context: Context): ItemRepository {
        val database = ListDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.listDao())
        val appExecutors = AppExecutors()

        return ItemRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}