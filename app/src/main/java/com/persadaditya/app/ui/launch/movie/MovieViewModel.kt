package com.persadaditya.app.ui.launch.movie

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.persadaditya.app.data.model.api.ErrorData
import com.persadaditya.app.data.model.response.MovieResponse
import com.persadaditya.app.data.remote.ApiObserver
import com.persadaditya.app.data.repository.AppRepo
import com.persadaditya.app.ui.base.BaseViewModel
import com.persadaditya.app.ui.launch.search.SearchNavigator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MovieViewModel @Inject constructor(appRepo: AppRepo): BaseViewModel<SearchNavigator>(appRepo) {

    val movie = MutableLiveData<MovieResponse>()

    fun loadMovie(movieId: String?){

        appRepo.detailMovie(movieId?:"")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { displayLoader(true) }
            .doOnComplete { displayLoader(false) }
            .subscribe(object : ApiObserver<MovieResponse>(compositeDisposable){
                override fun onSuccess(data: MovieResponse) {
                    if(data.response=="False"){
                        val throwError = Throwable(message = "Error data")
                        error.value = ErrorData(message = data.error?: "Error get data", throwable = throwError)
                    } else {
                        movie.value = data
                        Timber.i("aap, ${Gson().toJson(data)}")
                    }
                }

                override fun onError(e: ErrorData) {
                    error.value = e
                }
            })

    }

}