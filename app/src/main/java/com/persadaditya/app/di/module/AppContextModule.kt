package com.persadaditya.app.di.module

import android.content.Context
import com.persadaditya.app.App
import com.persadaditya.app.data.AppDataManager
import com.persadaditya.app.data.DataManager
import com.persadaditya.app.data.local.prefs.AppPreferencesHelper
import com.persadaditya.app.data.local.prefs.PreferencesHelper
import com.persadaditya.app.data.repository.AppRepo
import com.persadaditya.app.data.repository.Repo
import com.persadaditya.app.di.annotations.PreferenceInfo
import com.persadaditya.app.utils.AppConstants
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.TestScheduler
import javax.inject.Singleton

@Module
class AppContextModule {

    @Provides
    internal fun provideContext(app: App): Context {
        return app.applicationContext
    }

    @Provides
    @Singleton
    internal fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    internal fun provideRepository(appRepo: AppRepo): Repo {
        return appRepo
    }

    @Provides
    @Singleton
    internal fun provideTestScheduler(): TestScheduler{
        return TestScheduler()
    }

    @Provides
    @PreferenceInfo
    internal fun providePreferenceName(): String {
        return AppConstants.PREFERENCES_NAME
    }
}