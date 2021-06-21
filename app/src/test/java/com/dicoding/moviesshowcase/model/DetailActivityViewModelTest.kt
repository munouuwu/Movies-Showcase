package com.dicoding.moviesshowcase.model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.moviesshowcase.data.source.ItemRepository
import com.dicoding.moviesshowcase.data.source.local.entity.MvEntity
import com.dicoding.moviesshowcase.data.source.local.entity.TvEntity
import com.dicoding.moviesshowcase.repo.DataMovies
import com.dicoding.moviesshowcase.vo.Resource
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
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
    private lateinit var mvObserver: Observer<Resource<MvEntity>>

    @Mock
    private lateinit var tvObserver: Observer<Resource<TvEntity>>

    @Before
    public override fun setUp() {
        viewModel = DetailActivityViewModel(itemRepository)
    }

    @Test
    fun testGetMvById() {
        val dummyMv= Resource.success(mvDummy)
        val mv = MutableLiveData<Resource<MvEntity>>()
        mv.value = dummyMv

        `when` (mvId?.let { itemRepository.getDetailMv(it) }).thenReturn(mv)
        if (mvId != null) {
            viewModel.setSelectedMv(mvId)
        }
        viewModel.getMvById().observeForever(mvObserver)
        com.nhaarman.mockitokotlin2.verify(mvObserver).onChanged(dummyMv)
    }

    @Test
    fun testGetTvById() {
        val dummyTv= Resource.success(tvDummy)
        val tv = MutableLiveData<Resource<TvEntity>>()
        tv.value = dummyTv

        `when` (tvId?.let { itemRepository.getDetailTv(it) }).thenReturn(tv)
        if (tvId != null) {
            viewModel.setSelectedTv(tvId)
        }
        viewModel.getTvById().observeForever(tvObserver)
        com.nhaarman.mockitokotlin2.verify(tvObserver).onChanged(dummyTv)
    }

    @Test
    fun testSetFavMv() {
        val mvEntity = mvDummy

        val newState = !mvEntity.isFavorite
        itemRepository.setFavoriteMv(mvEntity, newState)
    }

    @Test
    fun testSetFavTv() {
        val tvEntity = tvDummy

        val newState = !tvEntity.isFavorite
        itemRepository.setFavoriteTv(tvEntity, newState)
    }
}