package com.persadaditya.app.data.local.prefs

import com.persadaditya.app.data.DataManager

interface PreferencesHelper {

    fun isDarkTheme(): Boolean
    fun setDarkTheme(boolean: Boolean)

    fun getCurrentUserLoggedMode(): Int?
    fun setCurrentUserLoggedMode(mode: DataManager.LoggedMode?)
}