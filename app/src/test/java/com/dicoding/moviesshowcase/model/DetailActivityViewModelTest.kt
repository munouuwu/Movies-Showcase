package com.dicoding.moviesshowcase.model

import com.dicoding.moviesshowcase.data.source.ItemRepository
import com.dicoding.moviesshowcase.data.source.remote.RemoteDataSource
import com.dicoding.moviesshowcase.repo.DataMovies
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class DetailActivityViewModelTest : TestCase() {
    private var itemRepository = ItemRepository.getInstance(remoteDataSource = RemoteDataSource.getInstance())

    private lateinit var detailActivityViewModel: DetailActivityViewModel
    private val mvData = itemRepository.getDetailMv()[0]
    private val tvData = itemRepository.getDetailTv()[0]
    private val mvId = mvData.id
    private val tvId = tvData.id


    @Before
    override fun setUp() {
        detailActivityViewModel = DetailActivityViewModel()
        detailActivityViewModel.setSelectedMv(mvId)
        detailActivityViewModel.setSelectedTv(tvId)
    }

    @Test
    fun testGetMvById() {
        val mv = detailActivityViewModel.getMvById()
        assertNotNull(mv)
        assertEquals(mvData.title, mv.title)
        assertEquals(mvData.overview, mv.overview)
        assertEquals(mvData.genre, mv.genre)
        assertEquals(mvData.release, mv.release)
        assertEquals(mvData.duration, mv.duration)
        assertEquals(mvData.language, mv.language)
        assertEquals(mvData.rating, mv.rating)
        assertEquals(mvData.imgPoster, mv.imgPoster)
    }

    @Test
    fun testGetTvById() {
        val tv = detailActivityViewModel.getTvById()
        assertNotNull(tv)
        assertEquals(tvData.title, tv.title)
        assertEquals(tvData.overview, tv.overview)
        assertEquals(tvData.genre, tv.genre)
        assertEquals(tvData.release, tv.release)
        assertEquals(tvData.duration, tv.duration)
        assertEquals(tvData.language, tv.language)
        assertEquals(tvData.rating, tv.rating)
        assertEquals(tvData.imgPoster, tv.imgPoster)
    }
}