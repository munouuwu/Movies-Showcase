package com.dicoding.moviesshowcase.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MvResponse (
    var id: String,
    var title: String,
    var overview: String,
    var genre: String,
    var release: String,
    var duration: String,
    var language: String,
    var rating: String,
    var imgPoster: Int
) : Parcelable