package com.persadaditya.app.di.module

import com.persadaditya.app.ui.launch.LauncherActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by M.Enes on 5/8/2019
 */
@Module
abstract class BuilderModule {

    @ContributesAndroidInjector(modules = [LauncherActivityModule::class])
    internal abstract fun bindLauncherActivity(): LauncherActivity
}