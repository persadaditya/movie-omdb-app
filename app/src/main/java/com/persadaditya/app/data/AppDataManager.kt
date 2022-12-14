package com.persadaditya.app.data

import com.persadaditya.app.data.local.prefs.PreferencesHelper
import com.persadaditya.app.data.remote.ApiHelper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager @Inject constructor(private val api: ApiHelper,private val preferencesHelper: PreferencesHelper) : DataManager {


    override fun isDarkTheme(): Boolean = preferencesHelper.isDarkTheme()
    override fun setDarkTheme(boolean: Boolean) = preferencesHelper.setDarkTheme(boolean)


    override fun getCurrentUserLoggedMode(): Int? {
        return preferencesHelper.getCurrentUserLoggedMode()
    }

    override fun setCurrentUserLoggedMode(mode: DataManager.LoggedMode?) {
        preferencesHelper.setCurrentUserLoggedMode(mode)
    }
}