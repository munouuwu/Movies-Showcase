package com.dicoding.moviesshowcase.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dicoding.moviesshowcase.data.source.remote.RemoteDataSource
import com.dicoding.moviesshowcase.model.LiveDataTestUtil
import com.dicoding.moviesshowcase.repo.DataMovies
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.doAnswer
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ItemRepositoryTest : TestCase() {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val itemRepository = FakeItemRepository(remote)

    private val listMvResponse = DataMovies.listDataDummyMoviesResponse()
    private val listTvResponse = DataMovies.listDataDummyTvsResponse()
    private val movieId = listMvResponse[0].id
    private val tvShowId = listTvResponse[0].id
    private val movieResponse = DataMovies.listDataDummyMoviesResponse()[0]
    private val tvShowResponse = DataMovies.listDataDummyTvsResponse()[0]

    @Test
    fun testGetTopRatedMv() {
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[0] as RemoteDataSource.LoadTopRatedMvCallback).onMvListReceived(
                    listMvResponse
                )
                null
            }.`when`(remote).getTopRatedMv(any())
        }

        val data = LiveDataTestUtil.getValue(itemRepository.getTopRatedMv())

        runBlocking {
            verify(remote).getTopRatedMv(any())
        }

        assertNotNull(data)
        assertEquals(listMvResponse.size.toLong(), data.size.toLong())
    }

    @Test
    fun testGetDetailMv() {
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[1] as RemoteDataSource.LoadDetailMvCallback).onMvDetailReceived(movieResponse)
                null
            }.`when`(remote).getDetailMv(eq(movieId), any())
        }

        val data = LiveDataTestUtil.getValue(itemRepository.getDetailMv(movieId))

        runBlocking {
            verify(remote).getDetailMv(eq(movieId), any())
        }

        assertNotNull(data)
        assertEquals(movieResponse.id, data.id)
    }

    @Test
    fun testGetTopRatedTv() {
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[0] as RemoteDataSource.LoadTopRatedTvCallback).onTvListReceived(listTvResponse)
                null
            }.`when`(remote).getTopRatedTv(any())
        }

        val data = LiveDataTestUtil.getValue(itemRepository.getTopRatedTv())

        runBlocking {
            verify(remote).getTopRatedTv(any())
        }

        assertNotNull(data)
        assertEquals(listTvResponse.size.toLong(), data.size.toLong())
    }

    @Test
    fun testGetDetailTv() {
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[1] as RemoteDataSource.LoadDetailTvCallback).onTvDetailReceived(tvShowResponse)
                null
            }.`when`(remote).getDetailTv(eq(tvShowId), any())
        }

        val data = LiveDataTestUtil.getValue(itemRepository.getDetailTv(tvShowId))

        runBlocking {
            verify(remote).getDetailTv(eq(tvShowId), any())
        }

        assertNotNull(data)
        assertEquals(tvShowResponse.id, data.id)
    }
}