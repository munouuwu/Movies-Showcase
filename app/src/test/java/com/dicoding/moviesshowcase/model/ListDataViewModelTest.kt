package com.dicoding.moviesshowcase.model

import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class ListDataViewModelTest : TestCase() {
    private lateinit var viewModel: ListDataViewModel

    @Before
    override fun setUp(){
        viewModel = ListDataViewModel()
    }

    @Test
    fun testGetMovies() {
        val mv = viewModel.getMovies()
        assertNotNull(mv)
        assertEquals(10, mv.size)
    }

    @Test
    fun testGetTvs() {
        val tv = viewModel.getTvs()
        assertNotNull(tv)
        assertEquals(10, tv.size)
    }
}