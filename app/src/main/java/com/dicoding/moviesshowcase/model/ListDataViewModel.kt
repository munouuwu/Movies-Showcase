package com.dicoding.moviesshowcase.model

import androidx.lifecycle.ViewModel
import com.dicoding.moviesshowcase.repo.DataMovies

class ListDataViewModel : ViewModel() {
    fun getMovies() : List<Data> = DataMovies.listDataMovies()
    fun getTvs() : List<Data> = DataMovies.listDataTvs()
}