package com.dicoding.moviesshowcase.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListResponse<T> (
    val status_message: String? = null,
    val status_code: Int? = null,
    val results: List<T>? = null
)