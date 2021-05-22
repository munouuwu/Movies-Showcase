package com.dicoding.moviesshowcase.data.source.remote.response

data class ListResponse<T> (
    val results: List<T>? = null
)