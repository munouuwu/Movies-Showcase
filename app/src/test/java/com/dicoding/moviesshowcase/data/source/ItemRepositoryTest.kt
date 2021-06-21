package com.dicoding.moviesshowcase.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dicoding.moviesshowcase.data.source.local.LocalDataSource
import com.dicoding.moviesshowcase.data.source.local.entity.MvEntity
import com.dicoding.moviesshowcase.data.source.local.entity.TvEntity
import com.dicoding.moviesshowcase.data.source.remote.RemoteDataSource
import com.dicoding.moviesshowcase.utils.LiveDataTestUtil
import com.dicoding.moviesshowcase.repo.DataMovies
import com.dicoding.moviesshowcase.utils.AppExecutors
import com.dicoding.moviesshowcase.utils.PagedListUtil
import com.dicoding.moviesshowcase.utils.TestExecutor
import com.dicoding.moviesshowcase.vo.Resource
import com.nhaarman.mockitokotlin2.*
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ItemRepositoryTest : TestCase() {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val local = Mockito.mock(LocalDataSource::class.java)

    private val appExecutors = Mockito.mock(AppExecutors::class.java)
    private val testExecutor = AppExecutors(TestExecutor(), TestExecutor(), TestExecutor())

    private val itemRepository = FakeItemRepository(remote, local, appExecutors)

    private val listMvResponse = DataMovies.listDataDummyMoviesResponse()
    private val listTvResponse = DataMovies.listDataDummyTvsResponse()

    private val mvId = listMvResponse[0].id
    private val tvId = listTvResponse[0].id

    private val mvDetail = DataMovies.listDataDummyMoviesResponse()[0]
    private val tvDetail = DataMovies.listDataDummyTvsResponse()[0]

    @Test
    fun testGetTopRatedMv() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MvEntity>
        Mockito.`when`(local.getListMv()).thenReturn(dataSourceFactory)
        itemRepository.getTopRatedMv()


        val mvEntity = Resource.success(PagedListUtil.mockPagedList(DataMovies.listDataDummyMovies()))

        verify(local).getListMv()

        assertNotNull(mvEntity.data)
        assertEquals(listMvResponse.size.toLong(), mvEntity.data?.size?.toLong())
    }

    @Test
    fun testGetDetailMv() {
        val dummyMv= MutableLiveData<MvEntity>()
        dummyMv.value = DataMovies.listDataDummyMovies()[0]
        Mockito.`when`(local.getDetailMv(mvId)).thenReturn(dummyMv)

        val mvEntities = LiveDataTestUtil.getValue(itemRepository.getDetailMv(mvId))
        verify(local).getDetailMv(mvId)
        Assert.assertNotNull(mvEntities.data)
        assertEquals(mvDetail.id, mvEntities.data?.mvId)
    }

    @Test
    fun testGetTopRatedTv() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvEntity>
        Mockito.`when`(local.getListTv()).thenReturn(dataSourceFactory)
        itemRepository.getTopRatedTv()


        val tvEntity = Resource.success(PagedListUtil.mockPagedList(DataMovies.listDataDummyTvs()))

        verify(local).getListTv()

        assertNotNull(tvEntity.data)
        assertEquals(listTvResponse.size.toLong(), tvEntity.data?.size?.toLong())
    }

    @Test
    fun testGetDetailTv() {
        val dummyTv= MutableLiveData<TvEntity>()
        dummyTv.value = DataMovies.listDataDummyTvs()[0]
        Mockito.`when`(local.getDetailTv(tvId)).thenReturn(dummyTv)

        val tvEntities = LiveDataTestUtil.getValue(itemRepository.getDetailTv(tvId))
        verify(local).getDetailTv(tvId)
        Assert.assertNotNull(tvEntities.data)
        assertEquals(tvDetail.id, tvEntities.data?.tvId)
    }

    @Test
    fun testGetFavoriteMv() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MvEntity>
        Mockito.`when`(local.getFavoriteMv()).thenReturn(dataSourceFactory)
        itemRepository.getFavoriteMv()

        val moviesEntities = Resource.success(PagedListUtil.mockPagedList(DataMovies.listDataDummyMovies()))
        verify(local).getFavoriteMv()
        Assert.assertNotNull(moviesEntities)
        assertEquals(listMvResponse.size, moviesEntities.data?.size)

    }

    @Test
    fun testGetFavoriteTv() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvEntity>
        Mockito.`when`(local.getFavoriteTv()).thenReturn(dataSourceFactory)
        itemRepository.getFavoriteTv()

        val tvsEntities = Resource.success(PagedListUtil.mockPagedList(DataMovies.listDataDummyTvs()))
        verify(local).getFavoriteTv()
        Assert.assertNotNull(tvsEntities)
        assertEquals(listTvResponse.size, tvsEntities.data?.size)
    }

    @Test
    fun testSetFavoriteMv() {
        val dummyMv = DataMovies.listDataDummyMovies()[0].copy(isFavorite = false)
        Mockito.`when`(appExecutors.diskIO()).thenReturn(testExecutor.diskIO())
        doNothing().`when`(local).updateMv(dummyMv, true)
        itemRepository.setFavoriteMv(dummyMv, true)

        verify(local, times(1)).updateMv(dummyMv,true)
    }

    @Test
    fun testSetFavoriteTv() {
        val dummyTv = DataMovies.listDataDummyTvs()[0].copy(isFavorite = false)
        Mockito.`when`(appExecutors.diskIO()).thenReturn(testExecutor.diskIO())
        doNothing().`when`(local).updateTv(dummyTv, true)
        itemRepository.setFavoriteTv(dummyTv, true)

        verify(local, times(1)).updateTv(dummyTv,true)
    }
}