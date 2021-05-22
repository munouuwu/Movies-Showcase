package com.dicoding.moviesshowcase.model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.moviesshowcase.data.Data
import com.dicoding.moviesshowcase.data.source.ItemRepository
import com.dicoding.moviesshowcase.repo.DataMovies
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ListDataViewModelTest : TestCase() {
    private val mvDummy = DataMovies.listDataDummyMovies()
    private val tvDummy = DataMovies.listDataDummyTvs()

    private lateinit var viewModel: ListDataViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var itemRepository: ItemRepository

    @Mock
    private lateinit var observer: Observer<List<Data>>

    @Before
    override public fun setUp() {
        viewModel = ListDataViewModel(itemRepository)
    }

    @Test
    fun testGetTopRatedMv() {
        val movie = MutableLiveData<List<Data>>()
        movie.value = mvDummy

        `when`(itemRepository.getTopRatedMv()).thenReturn(movie)

        val dataListMovie = viewModel.getMovies().value

        verify(itemRepository).getTopRatedMv()
        assertNotNull(dataListMovie)
        assertEquals(10, dataListMovie?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(mvDummy)
    }

    @Test
    fun testGetTopRatedTv() {
        val tvShow = MutableLiveData<List<Data>>()
        tvShow.value = tvDummy

        `when`(itemRepository.getTopRatedTv()).thenReturn(tvShow)

        val dataListTvShow = viewModel.getTvs().value

        verify(itemRepository).getTopRatedTv()
        assertNotNull(dataListTvShow)
        assertEquals(10, dataListTvShow?.size)

        viewModel.getTvs().observeForever(observer)
        verify(observer).onChanged(tvDummy)
    }
}