package me.jdvp.androidaspectexample.application

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.jdvp.androidaspectexample.activity.MainActivity

/**
 * Module that defines which views classes will be injected
 */
@Module
internal abstract class ViewsModule {
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity?
}