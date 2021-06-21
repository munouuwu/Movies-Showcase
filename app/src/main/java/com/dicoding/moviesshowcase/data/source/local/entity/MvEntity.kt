package com.dicoding.moviesshowcase.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dicoding.moviesshowcase.data.source.remote.response.GenreResponse
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tb_favorite_mv")
@Parcelize
data class MvEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @NonNull
    @ColumnInfo(name = "mvId")
    var mvId: Int = 0,

    @ColumnInfo(name = "mvTitle")
    var title: String? = null,

    @ColumnInfo(name = "mvOverview")
    var overview: String? = null,

    @ColumnInfo(name = "mvRelease")
    var releaseDate: String? = null,

    @ColumnInfo(name = "mvRuntime")
    var runtime: Int? = null,

    @ColumnInfo(name = "mvGenres")
    var genres: String? = null,

    @ColumnInfo(name = "mvLanguage")
    var language: String? = null,

    @ColumnInfo(name = "mvRating")
    var rating: Double? = null,

    @ColumnInfo(name = "mvPoster")
    var poster: String? = null,

    @NonNull
    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
): Parcelable