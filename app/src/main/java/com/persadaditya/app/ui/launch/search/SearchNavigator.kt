package com.persadaditya.app.ui.launch.search

import android.app.Activity
import android.content.Context
import io.reactivex.Scheduler

interface SearchNavigator {


    fun activity(): Activity

    fun context(): Context



}