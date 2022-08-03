package com.persadaditya.app.data

import com.persadaditya.app.data.local.prefs.PreferencesHelper
import com.persadaditya.app.data.remote.ApiHelper

interface DataManager: PreferencesHelper {

    enum class LoggedMode constructor(val type: Int) {

        LOGGED_OUT(0),
        LOGGED_IN(1),
    }

}