package com.persadaditya.app.di.annotations

import javax.inject.Qualifier
import kotlin.annotation.Retention

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class PreferenceInfo {
}