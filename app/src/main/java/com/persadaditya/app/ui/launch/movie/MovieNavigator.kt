package com.persadaditya.app.ui.launch.movie

import android.app.Activity
import android.content.Context

interface MovieNavigator {


    fun activity(): Activity

    fun context(): Context
}