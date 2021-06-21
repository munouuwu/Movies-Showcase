package com.dicoding.moviesshowcase.model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.moviesshowcase.data.source.ItemRepository
import com.dicoding.moviesshowcase.data.source.local.entity.MvEntity
import com.dicoding.moviesshowcase.data.source.local.entity.TvEntity
import com.dicoding.moviesshowcase.vo.Resource
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ListDataViewModelTest : TestCase() {
    private lateinit var viewModel: ListDataViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var itemRepository: ItemRepository

    @Mock
    private lateinit var mvObserver: Observer<Resource<PagedList<MvEntity>>>

    @Mock
    private lateinit var tvObserver: Observer<Resource<PagedList<TvEntity>>>

    @Mock
    private lateinit var mvFavObserver: Observer<PagedList<MvEntity>>

    @Mock
    private lateinit var tvFavObserver: Observer<PagedList<TvEntity>>


    @Mock
    private lateinit var mvPagedList: PagedList<MvEntity>

    @Mock
    private lateinit var tvPagedList: PagedList<TvEntity>

    @Before
    public override fun setUp() {
        viewModel = ListDataViewModel(itemRepository)
    }

    @Test
    fun testGetMovies() {
        val dummyMv = Resource.success(mvPagedList)
        `when`(dummyMv.data?.size).thenReturn(10)
        val mvs = MutableLiveData<Resource<PagedList<MvEntity>>>()
        mvs.value = dummyMv

        `when`(itemRepository.getTopRatedMv()).thenReturn(mvs)
        val mvEntities = viewModel.getMovies().value?.data
        com.nhaarman.mockitokotlin2.verify(itemRepository).getTopRatedMv()
        Assert.assertNotNull(mvEntities)
        Assert.assertEquals(10, mvEntities?.size)

        viewModel.getMovies().observeForever(mvObserver)
        com.nhaarman.mockitokotlin2.verify(mvObserver).onChanged(dummyMv)
    }

    @Test
    fun testGetTvs() {
        val dummyTv = Resource.success(tvPagedList)
        `when`(dummyTv.data?.size).thenReturn(10)
        val tvs = MutableLiveData<Resource<PagedList<TvEntity>>>()
        tvs.value = dummyTv

        `when`(itemRepository.getTopRatedTv()).thenReturn(tvs)
        val tvEntities = viewModel.getTvs().value?.data
        com.nhaarman.mockitokotlin2.verify(itemRepository).getTopRatedTv()
        Assert.assertNotNull(tvEntities)
        Assert.assertEquals(10, tvEntities?.size)

        viewModel.getTvs().observeForever(tvObserver)
        com.nhaarman.mockitokotlin2.verify(tvObserver).onChanged(dummyTv)
    }

    @Test
    fun testGetFavoriteMv() {
        val dummyMv = mvPagedList
        `when`(dummyMv.size).thenReturn(10)
        val mv = MutableLiveData<PagedList<MvEntity>>()
        mv.value = dummyMv

        `when`(itemRepository.getFavoriteMv()).thenReturn(mv)
        val mvEntities = viewModel.getFavoriteMv().value
        com.nhaarman.mockitokotlin2.verify(itemRepository).getFavoriteMv()
        Assert.assertNotNull(mvEntities)
        Assert.assertEquals(10, mvEntities?.size)

        viewModel.getFavoriteMv().observeForever(mvFavObserver)
        com.nhaarman.mockitokotlin2.verify(mvFavObserver).onChanged(dummyMv)
    }

    @Test
    fun testGetFavoriteTv() {
        val dummyTv = tvPagedList
        `when`(dummyTv.size).thenReturn(10)
        val tv = MutableLiveData<PagedList<TvEntity>>()
        tv.value = dummyTv

        `when`(itemRepository.getFavoriteTv()).thenReturn(tv)
        val tvEntities = viewModel.getFavoriteTv().value
        com.nhaarman.mockitokotlin2.verify(itemRepository).getFavoriteTv()
        Assert.assertNotNull(tvEntities)
        Assert.assertEquals(10, tvEntities?.size)

        viewModel.getFavoriteTv().observeForever(tvFavObserver)
        com.nhaarman.mockitokotlin2.verify(tvFavObserver).onChanged(dummyTv)

    }
}