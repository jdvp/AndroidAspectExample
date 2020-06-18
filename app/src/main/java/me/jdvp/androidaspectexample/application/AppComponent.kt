package me.jdvp.androidaspectexample.application

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ViewsModule::class])
internal interface AppComponent : AndroidInjector<AspectExampleApplication> {
    @Component.Factory
    abstract class Builder : AndroidInjector.Factory<AspectExampleApplication>
}
