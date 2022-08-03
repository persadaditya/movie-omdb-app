package com.persadaditya.app.di.module

import com.persadaditya.app.ui.launch.movie.MovieFragment
import com.persadaditya.app.ui.launch.search.SearchFragment
import com.persadaditya.app.ui.launch.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LauncherActivityModule {

    @ContributesAndroidInjector
    abstract fun provideSplashFragmentFactory(): SplashFragment


    @ContributesAndroidInjector
    abstract fun provideSearchFragmentFactory(): SearchFragment

    @ContributesAndroidInjector
    abstract fun provideMovieFragmentFactory(): MovieFragment

}