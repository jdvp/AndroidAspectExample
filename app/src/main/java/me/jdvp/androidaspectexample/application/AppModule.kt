package me.jdvp.androidaspectexample.application

import dagger.Module
import me.jdvp.androidaspectexample.viewmodel.impl.ViewModelModule

/**
 * Module that includes app wide dependencies that are not ViewModels (or included by ViewModelModule)
 */
@Module(includes = [ViewModelModule::class])
internal class AppModule