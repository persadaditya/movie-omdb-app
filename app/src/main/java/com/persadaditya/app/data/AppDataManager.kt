package com.persadaditya.app.data

import com.persadaditya.app.data.local.prefs.PreferencesHelper
import com.persadaditya.app.data.model.request.LoginReq
import com.persadaditya.app.data.remote.ApiHelper
import com.persadaditya.app.data.model.UserModel
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by M.Enes on 24.04.2019
 */
@Singleton
class AppDataManager @Inject constructor(private val api: ApiHelper,private val preferencesHelper: PreferencesHelper) : DataManager {


    override fun getUser(): UserModel? = preferencesHelper.getUser()
    override fun setUser(model: UserModel?) = preferencesHelper.setUser(model)

    override fun isDarkTheme(): Boolean = preferencesHelper.isDarkTheme()
    override fun setDarkTheme(boolean: Boolean) = preferencesHelper.setDarkTheme(boolean)


    override fun getCurrentUserLoggedMode(): Int? {
        return preferencesHelper.getCurrentUserLoggedMode()
    }

    override fun setCurrentUserLoggedMode(mode: DataManager.LoggedMode?) {
        preferencesHelper.setCurrentUserLoggedMode(mode)
    }
}