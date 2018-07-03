package me.jdvp.androidaspectexample.application;

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

    @Override
    public AndroidInjector<DaggerSetupApplication> applicationInjector() {
        if (injector == null) {
            injector = DaggerAppComponent.builder().create(this);
        }
        return injector;
    }

    public static @Nullable AppComponent getAppComponent() {
        return (AppComponent) injector;
    }
}
