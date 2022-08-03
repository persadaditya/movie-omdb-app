package com.persadaditya.app.viewModel

import androidx.annotation.VisibleForTesting
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.persadaditya.app.data.model.response.SearchResponse
import com.persadaditya.app.data.remote.ApiHelper
import com.persadaditya.app.data.repository.AppRepo
import com.persadaditya.app.ui.launch.search.SearchViewModel
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.TestScheduler
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.concurrent.*


@RunWith(JUnit4::class)
class SearchViewModelTest {

    lateinit var searchViewModel: SearchViewModel
    lateinit var appRepo: AppRepo

    @Mock
    lateinit var apiHelper: ApiHelper

    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        appRepo = AppRepo(apiHelper)
        searchViewModel = SearchViewModel(appRepo,)
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler: Callable<Scheduler?>? -> Schedulers.trampoline() }
    }


    @Test
    fun getSearchMovieTest(){
        Mockito.`when`(appRepo.searchMovie("doo",null,null,1))
            .thenReturn(Observable.just(SearchResponse()))

        searchViewModel.onSearchData("doo")

        val result = searchViewModel.searchData.getOrAwaitValue()

        Assert.assertEquals(SearchResponse(), result)

    }

    @VisibleForTesting(otherwise = VisibleForTesting.NONE)
    fun <T> LiveData<T>.getOrAwaitValue(
        time: Long = 2,
        timeUnit: TimeUnit = TimeUnit.SECONDS,
        afterObserve: () -> Unit = {}
    ): T? {
        var data: T? = null
        val latch = CountDownLatch(1)
        val observer = object : Observer<T> {
            override fun onChanged(o: T?) {
                data = o
                latch.countDown()
                this@getOrAwaitValue.removeObserver(this)
            }
        }
        this.observeForever(observer)
        try {
            afterObserve.invoke()
            if (!latch.await(time, timeUnit)) {
                throw TimeoutException("LiveData value was never set.")
            }
        } finally {
            this.removeObserver(observer)
        }
        @Suppress("UNCHECKED_CAST")
        return data as T
    }
}