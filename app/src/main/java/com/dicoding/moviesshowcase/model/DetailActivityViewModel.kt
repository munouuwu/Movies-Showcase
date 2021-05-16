package com.dicoding.moviesshowcase.model

import androidx.lifecycle.ViewModel
import com.dicoding.moviesshowcase.repo.DataMovies

class DetailActivityViewModel : ViewModel() {
    private lateinit var mvId : String
    private lateinit var tvId : String

    private fun getMovies() : ArrayList<Data> = DataMovies.listDataMovies() as ArrayList<Data>
    private fun getTvs() : ArrayList<Data> = DataMovies.listDataTvs() as ArrayList<Data>

    fun setSelectedMv(mvId: String) {
        this.mvId = mvId
    }

    fun setSelectedTv(tvId: String) {
        this.tvId = tvId
    }

    fun getMvById(): Data {
        lateinit var result: Data
        val listMovie = getMovies()
        for (mv in listMovie) {
            if (mv.id == mvId) {
                result = mv
                break
            }
        }
        return  result
    }

    fun getTvById(): Data {
        lateinit var result: Data
        val listTvShow = getTvs()
        for (tv in listTvShow) {
            if (tv.id == tvId) {
                result = tv
                break
            }
        }
        return result
    }
}