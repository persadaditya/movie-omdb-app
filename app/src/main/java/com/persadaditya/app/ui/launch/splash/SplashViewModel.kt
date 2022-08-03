package com.persadaditya.app.ui.launch.splash

import com.persadaditya.app.data.DataManager
import com.persadaditya.app.data.repository.AppRepo
import com.persadaditya.app.ui.base.BaseViewModel
import javax.inject.Inject

class SplashViewModel @Inject constructor(appRepo: AppRepo): BaseViewModel<SplashNavigator>(appRepo) {
}