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
class DetailActivityViewModelTest : TestCase() {
    private val mvDummy = DataMovies.listDataDummyMovies()[0]
    private val tvDummy = DataMovies.listDataDummyTvs()[0]

    private val mvId = mvDummy.id
    private val tvId = tvDummy.id

    private lateinit var viewModel: DetailActivityViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var itemRepository: ItemRepository

    @Mock
    private lateinit var observer: Observer<Data>

    @Before
    override public fun setUp() {
        viewModel = DetailActivityViewModel(itemRepository)
    }

    @Test
    fun getMovieDetail() {
        val movie = MutableLiveData<Data>()
        movie.value = mvDummy

        `when`(itemRepository.getDetailMv(mvId)).thenReturn(movie)

        viewModel.setSelectedMv(mvId)
        val mvData = viewModel.getMvById().value as Data

        assertNotNull(mvData)
        assertEquals(mvDummy.id, mvData.id)
        assertEquals(mvDummy.title, mvData.title)
        assertEquals(mvDummy.overview, mvData.overview)
        assertEquals(mvDummy.genre, mvData.genre)
        assertEquals(mvDummy.duration, mvData.duration)
        assertEquals(mvDummy.language, mvData.language)
        assertEquals(mvDummy.rating, mvData.rating)
        assertEquals(mvDummy.release, mvData.release)
        assertEquals(mvDummy.imgPoster, mvData.imgPoster)

        viewModel.getMvById().observeForever(observer)
        verify(observer).onChanged(mvDummy)

    }

    @Test
    fun getTvShowDetail() {
        val tvShow = MutableLiveData<Data>()
        tvShow.value = tvDummy

        `when`(itemRepository.getDetailTv(tvId)).thenReturn(tvShow)

        viewModel.setSelectedTv(tvId)
        val tvData = viewModel.getTvById().value as Data

        assertNotNull(tvData)
        assertEquals(tvDummy.id, tvData.id)
        assertEquals(tvDummy.title, tvData.title)
        assertEquals(tvDummy.overview, tvData.overview)
        assertEquals(tvDummy.genre, tvData.genre)
        assertEquals(tvDummy.season, tvData.season)
        assertEquals(tvDummy.episode, tvData.episode)
        assertEquals(tvDummy.language, tvData.language)
        assertEquals(tvDummy.rating, tvData.rating)
        assertEquals(tvDummy.release, tvData.release)
        assertEquals(tvDummy.imgPoster, tvData.imgPoster)

        viewModel.getTvById().observeForever(observer)
        verify(observer).onChanged(tvDummy)
    }
}