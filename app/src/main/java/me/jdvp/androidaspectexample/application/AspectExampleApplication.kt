package me.jdvp.androidaspectexample.application

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Application class used for setting up Dagger
 */
class AspectExampleApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<AspectExampleApplication> {
        return injector ?:  DaggerAppComponent.factory().create(this).apply {
            injector = this
        }
    }

    companion object {
        var injector: AndroidInjector<AspectExampleApplication>? = null
    }
}