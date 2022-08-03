package com.persadaditya.app.data.local.prefs

import com.persadaditya.app.data.DataManager
import com.persadaditya.app.data.model.UserModel

/**
 * Created by M.Enes on 5/9/2019
 */
interface PreferencesHelper {

    fun getUser(): UserModel?
    fun setUser(model: UserModel?)

    fun isDarkTheme(): Boolean
    fun setDarkTheme(boolean: Boolean)

    fun getCurrentUserLoggedMode(): Int?
    fun setCurrentUserLoggedMode(mode: DataManager.LoggedMode?)
}