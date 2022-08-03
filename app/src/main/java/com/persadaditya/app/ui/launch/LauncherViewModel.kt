package com.persadaditya.app.ui.launch

import com.persadaditya.app.data.DataManager
import com.persadaditya.app.data.repository.AppRepo
import com.persadaditya.app.ui.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by M.Enes on 24.04.2019
 */
class LauncherViewModel @Inject constructor(appRepo: AppRepo): BaseViewModel<LauncherNavigator>(appRepo) {

}