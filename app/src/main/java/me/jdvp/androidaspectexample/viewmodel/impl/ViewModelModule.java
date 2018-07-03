package me.jdvp.androidaspectexample.viewmodel.impl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.jdvp.androidaspectexample.viewmodel.LoggingViewModel;

/**
 * Module that provides ViewModel dependencies. Also includes lower-level modules. In this case, we are including a module
 * for Services but if we wanted to also do caching, we might have another layer between the VM and services.
 *
 * Created by jdvp on 6/18/18.
 */

@Module
public class ViewModelModule {
    @Provides
    @Singleton
    LoggingViewModel loggingViewModel() {
        return new LoggingViewModelImpl();
    }
}