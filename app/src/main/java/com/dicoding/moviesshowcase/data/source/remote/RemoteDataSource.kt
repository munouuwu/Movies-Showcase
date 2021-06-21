package com.dicoding.moviesshowcase.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.moviesshowcase.data.source.remote.api.ApiConfig
import com.dicoding.moviesshowcase.data.source.remote.api.ApiService
import com.dicoding.moviesshowcase.data.source.remote.response.ListResponse
import com.dicoding.moviesshowcase.data.source.remote.response.MvResponse
import com.dicoding.moviesshowcase.data.source.remote.response.TvResponse
import com.dicoding.moviesshowcase.data.source.remote.vo.ApiResponse
import com.dicoding.moviesshowcase.utils.EspressoIdlingResource
import com.dicoding.moviesshowcase.utils.Helper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource constructor(private val apiService: ApiService){
    companion object{
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource(ApiConfig.instance)
        }
    }

    fun getTopRatedMv() : LiveData<ApiResponse<List<MvResponse>>>{
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<List<MvResponse>>>()
        val client = apiService.getListMv(Helper.API_KEY)

        client.enqueue(object : Callback<ListResponse<MvResponse>> {
            override fun onResponse(
                call: Call<ListResponse<MvResponse>>,
                response: Response<ListResponse<MvResponse>>
            ) {
                result.value = ApiResponse.success(response.body()?.results as List<MvResponse>)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<ListResponse<MvResponse>>, t: Throwable) {
                Log.e("RemoteDataSource", "getMovies onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
        return result
    }

    fun getTopRatedTv() : LiveData<ApiResponse<List<TvResponse>>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<List<TvResponse>>>()
        val client = apiService.getListTv(Helper.API_KEY)

        client.enqueue(object : Callback<ListResponse<TvResponse>> {
            override fun onResponse(
                call: Call<ListResponse<TvResponse>>,
                response: Response<ListResponse<TvResponse>>
            ) {
                result.value = ApiResponse.success(response.body()?.results as List<TvResponse>)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<ListResponse<TvResponse>>, t: Throwable) {
                Log.e("RemoteDataSource", "getMovies onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
        return result
    }


    fun getDetailMv(id: Int): LiveData<ApiResponse<MvResponse>> {
        EspressoIdlingResource.increment()
        val resultFilm = MutableLiveData<ApiResponse<MvResponse>>()
        val client = apiService.getDetailMv(id, Helper.API_KEY)
        client.enqueue(object : Callback<MvResponse> {
            override fun onResponse(call: Call<MvResponse>, response: Response<MvResponse>) {
                resultFilm.value = ApiResponse.success(response.body() as MvResponse)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MvResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getDetailMovies onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
        return resultFilm
    }

    fun getDetailTv(id: Int): LiveData<ApiResponse<TvResponse>> {
        EspressoIdlingResource.increment()
        val resultFilm = MutableLiveData<ApiResponse<TvResponse>>()
        val client = apiService.getDetailTv(id, Helper.API_KEY)
        client.enqueue(object : Callback<TvResponse> {
            override fun onResponse(call: Call<TvResponse>, response: Response<TvResponse>) {
                resultFilm.value = ApiResponse.success(response.body() as TvResponse)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getDetailMovies onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
        return resultFilm
    }
}