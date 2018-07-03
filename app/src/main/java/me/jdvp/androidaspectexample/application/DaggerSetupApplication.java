package me.jdvp.androidaspectexample.application;

import android.content.Context;
import android.support.annotation.Nullable;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Application class used for setting up Dagger
 *
 * Created by jdvp on 6/18/18.
 */

public class DaggerSetupApplication extends DaggerApplication {
    private static AndroidInjector<DaggerSetupApplication> injector;
    private static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this.getApplicationContext();
    }

    @Override
    public AndroidInjector<DaggerSetupApplication> applicationInjector() {
        if (injector == null) {
            injector = DaggerAppComponent.builder().create(this);
        }
        return injector;
    }

    public static Context getApplicationContextInstance() {
        return applicationContext;
    }

    public static @Nullable AppComponent getAppComponent() {
        return (AppComponent) injector;
    }
}
