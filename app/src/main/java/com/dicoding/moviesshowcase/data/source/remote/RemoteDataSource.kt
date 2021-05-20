package com.dicoding.moviesshowcase.data.source.remote

import com.dicoding.moviesshowcase.repo.EspressoIdlingResource

class RemoteDataSource {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    fun getListMv(callback: LoadListMvCallback){
        EspressoIdlingResource.increment()
        ApiClient.instance.
    }

    fun getModules(courseId: String): List<ModuleResponse> = jsonHelper.loadModule(courseId)

    fun getContent(moduleId: String): ContentResponse = jsonHelper.loadContent(moduleId)
}