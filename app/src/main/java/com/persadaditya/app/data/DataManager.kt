package com.persadaditya.app.data

import com.persadaditya.app.data.local.prefs.PreferencesHelper
import com.persadaditya.app.data.remote.ApiHelper

/**
 * Created by M.Enes on 5/9/2019
 */
interface DataManager: PreferencesHelper {

    enum class LoggedMode constructor(val type: Int) {

        LOGGED_OUT(0),
        LOGGED_IN(1),
    }

}