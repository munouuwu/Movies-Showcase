package com.dicoding.moviesshowcase.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListResponse<T> (
    val statusMessage: String? = null,
    val statusCode: Int? = null,
    val result: List<T>? = null
) : Parcelable