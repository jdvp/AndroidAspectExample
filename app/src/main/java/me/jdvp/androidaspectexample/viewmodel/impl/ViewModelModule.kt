package me.jdvp.androidaspectexample.viewmodel.impl

import dagger.Module
import dagger.Provides
import me.jdvp.androidaspectexample.viewmodel.LoggingViewModel
import javax.inject.Singleton

/**
 * Module that provides ViewModel dependencies. Also includes lower-level modules (not applicable in this
 * example application as we have no networking or caching).
 */
@Module
class ViewModelModule {
    @Provides
    @Singleton
    fun loggingViewModel(): LoggingViewModel {
        return LoggingViewModelImpl()
    }
}