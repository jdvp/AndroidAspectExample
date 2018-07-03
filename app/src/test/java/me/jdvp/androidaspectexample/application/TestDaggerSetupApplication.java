package me.jdvp.androidaspectexample.application;

import dagger.android.AndroidInjector;

/**
 * Test application we use for Robolectric to ensure we can inject mocks into our activities
 * and tests (mostly for Robolectric tests)
 *
 * Created by jdvp on 6/19/18.
 */

public class TestDaggerSetupApplication extends DaggerSetupApplication {
    AndroidInjector<DaggerSetupApplication> injector;

    @Override
    public AndroidInjector<DaggerSetupApplication> applicationInjector() {
        if (injector == null) {
            injector = DaggerTestAppComponent.builder().create(this);
        }

        return injector;
    }

    public TestAppComponent getTestAppComponent() {
        return (TestAppComponent) applicationInjector();
    }
}
