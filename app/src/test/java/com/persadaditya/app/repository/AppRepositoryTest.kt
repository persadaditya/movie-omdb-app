package com.persadaditya.app.repository

import com.nhaarman.mockitokotlin2.given
import com.persadaditya.app.data.model.response.MovieResponse
import com.persadaditya.app.data.model.response.SearchResponse
import com.persadaditya.app.data.remote.ApiHelper
import com.persadaditya.app.data.repository.AppRepo
import io.reactivex.Observable
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class AppRepositoryTest {

    lateinit var appRepo: AppRepo

    @Mock
    lateinit var apiHelper: ApiHelper

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        appRepo = AppRepo(apiHelper)
    }


    @Test
    fun `giveValidResponse whenGetSearchMovie thenReturnSearch`(){

        given(apiHelper.searchMovie("doo", null,null, 1))
            .willReturn(Observable.just(SearchResponse()))

        val testObserver = apiHelper.searchMovie("doo", null, null, 1)

        testObserver.test()
            .assertComplete()
            .assertNoErrors()
            .assertResult(SearchResponse())
            .dispose()
    }

    @Test
    fun `getValidResponse whenGetDetailMovie thenReturnErrorMovieResponse`(){
        given(apiHelper.detailMovie("tt11234")).willReturn(Observable.just(MovieResponse()))

        val apiBlock = apiHelper.detailMovie("tt11234").blockingFirst()

        Assert.assertEquals(apiBlock, MovieResponse())
    }
}