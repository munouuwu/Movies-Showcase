package com.dicoding.moviesshowcase.model

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.moviesshowcase.data.Injection
import com.dicoding.moviesshowcase.data.source.ItemRepository

class ViewModelFactory private constructor(private val itemRepository: ItemRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideItemRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(DetailActivityViewModel::class.java) -> {
                return DetailActivityViewModel(itemRepository) as T
            }
            modelClass.isAssignableFrom(ListDataViewModel::class.java) -> {
                return ListDataViewModel(itemRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}
