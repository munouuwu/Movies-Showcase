package com.dicoding.moviesshowcase.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MvResponse (
    var id: Int,
    var title: String,
    var overview: String,
    var release_date: String,
    var runtime: Int,
    var genres: List<GenreResponse>,
    var original_language: String,
    var vote_average: Double,
    var poster_path: String
) : Parcelable