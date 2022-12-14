package com.persadaditya.app.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.persadaditya.app.data.DataManager
import com.persadaditya.app.data.model.api.ErrorData
import com.persadaditya.app.data.repository.AppRepo
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.lang.ref.WeakReference

open class BaseViewModel<N>(
    val appRepo: AppRepo
): ViewModel() {


    private var mNavigator: WeakReference<N>? = null
    val loader: MutableLiveData<Boolean> = MutableLiveData()
    val error: MutableLiveData<ErrorData?> = MutableLiveData()
    var compositeDisposable: CompositeDisposable = CompositeDisposable()
    var scheduler = Schedulers.io()

    fun displayLoader(isLoading: Boolean) {
        loader.value = isLoading
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }


    fun getNavigator(): N? {
        return mNavigator?.get()
    }

    fun setNavigator(navigator: N) {
        this.mNavigator = WeakReference(navigator)
    }
}