package com.persadaditya.app.ui.launch.search

import android.view.View
import com.persadaditya.app.data.repository.AppRepo
import com.persadaditya.app.ui.base.BaseViewModel
import javax.inject.Inject

class SearchViewModel @Inject constructor(appRepo: AppRepo): BaseViewModel<SearchNavigator>(appRepo) {


    var search=""

    private fun onSearchAction(view: View){

    }

}