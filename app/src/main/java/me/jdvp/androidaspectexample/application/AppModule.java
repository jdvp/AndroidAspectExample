package me.jdvp.androidaspectexample.application;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.jdvp.androidaspectexample.viewmodel.impl.ViewModelModule;

/**
 * Module that includes app wide dependencies that are not ViewModels (or included by ViewModelModule)
 *
 * Created by jdvp on 6/19/18.
 */
@Module(
        includes = ViewModelModule.class
)
class AppModule {
    @Provides
    @Singleton
    Context context() {
        return DaggerSetupApplication.getApplicationContextInstance();
    }
}
