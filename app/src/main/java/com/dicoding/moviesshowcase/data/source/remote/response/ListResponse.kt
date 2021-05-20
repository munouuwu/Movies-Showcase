package com.dicoding.moviesshowcase.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class ListResponse<T> (
    val results: List<T>? = null
)