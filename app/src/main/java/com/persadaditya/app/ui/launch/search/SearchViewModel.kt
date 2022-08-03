package com.persadaditya.app.ui.launch.search

import android.content.Context
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.MutableLiveData
import com.persadaditya.app.data.model.api.ErrorData
import com.persadaditya.app.data.model.response.SearchResponse
import com.persadaditya.app.data.remote.ApiObserver
import com.persadaditya.app.data.repository.AppRepo
import com.persadaditya.app.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.TestScheduler
import org.w3c.dom.Text
import timber.log.Timber
import javax.inject.Inject


class SearchViewModel @Inject constructor(appRepo: AppRepo): BaseViewModel<SearchNavigator>(appRepo) {


    var search=""

    val searchData = MutableLiveData<SearchResponse>(null)

    fun onSearchData(query: String){
        appRepo.searchMovie(query, null, null, 1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { displayLoader(true) }
            .doOnComplete { displayLoader(false) }
            .subscribe(object : ApiObserver<SearchResponse>(compositeDisposable){
                override fun onSuccess(data: SearchResponse) {
                    if(data.response=="False"){
                        val throwError = Throwable(message = "Error data")
                        error.value = ErrorData(message = data.error?: "Error get data", throwable = throwError)
                    } else {
                        searchData.value = data
                    }
                }

                override fun onError(e: ErrorData) {
                    error.value = e
                }
            })
    }

    /**
    * see this function xml in search edit text
    * {@link fragment_search.xml}
    */
    fun afterSearchTextChanged(s: CharSequence) {
        search = s.toString()
    }

    /**
     * see this function xml in search edit text
     * {@link fragment_search.xml}
     */
    fun onEditorAction(view: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        onSearchData(search)
        return true
    }


}

