package com.dicoding.moviesshowcase.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dicoding.moviesshowcase.data.source.local.entity.MvEntity
import com.dicoding.moviesshowcase.data.source.local.entity.TvEntity

@Database(entities = [MvEntity::class, TvEntity::class], version = 1, exportSchema = false)
abstract class ListDatabase : RoomDatabase() {
    abstract fun listDao(): ListDao

    companion object {

        @Volatile
        private var INSTANCE: ListDatabase? = null

        fun getInstance(context: Context): ListDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    ListDatabase::class.java,
                    "list.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }
}