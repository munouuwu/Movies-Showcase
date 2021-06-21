package com.dicoding.moviesshowcase.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dicoding.moviesshowcase.data.source.remote.response.GenreResponse
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tb_favorite_tv")
@Parcelize
data class TvEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @NonNull
    @ColumnInfo(name = "tvId")
    var tvId: Int = 0,

    @ColumnInfo(name = "tvTitle")
    var title: String? = null,

    @ColumnInfo(name = "tvOverview")
    var overview: String? = null,

    @ColumnInfo(name = "tvRelease")
    var releaseDate: String? = null,

    @ColumnInfo(name = "tvGenres")
    var genres: String? = null,

    @ColumnInfo(name = "tvEpisode")
    var episodes: Int? = null,

    @ColumnInfo(name = "tvSeason")
    var seasons: Int? = null,

    @ColumnInfo(name = "tvLanguage")
    var language: String? = null,

    @ColumnInfo(name = "tvRating")
    var rating: Double? = null,

    @ColumnInfo(name = "tvPoster")
    var poster: String? = null,

    @NonNull
    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
): Parcelable