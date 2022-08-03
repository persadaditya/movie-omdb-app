package com.persadaditya.app.di.module

import com.persadaditya.app.ui.launch.login.LoginFragment
import com.persadaditya.app.ui.launch.search.SearchFragment
import com.persadaditya.app.ui.launch.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by M.Enes on 24.04.2019
 */
@Module
abstract class LauncherActivityModule {

    @ContributesAndroidInjector
    abstract fun provideSplashFragmentFactory(): SplashFragment

    @ContributesAndroidInjector
    abstract fun provideLoginFragmentFactory(): LoginFragment

    @ContributesAndroidInjector
    abstract fun provideSearchFragmentFactory(): SearchFragment

}