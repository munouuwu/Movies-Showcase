package com.dicoding.moviesshowcase.data.source.remote.response

data class TvResponse (
    var id: Int,
    var name: String,
    var overview: String,
    var first_air_date: String,
    var genres: List<GenreResponse>,
    var number_of_episodes: Int,
    var number_of_seasons: Int,
    var original_language: String,
    var vote_average: Double,
    var poster_path: String
)