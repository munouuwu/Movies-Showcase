package com.dicoding.moviesshowcase.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data (
    var id: Int,
    var title: String,
    var overview: String,
    var genre: String?,
    var release: String,
    var duration: Int?,
    var language: String,
    var rating: Double,
    var episode: Int?,
    var season: Int?,
    var imgPoster: String
) : Parcelable