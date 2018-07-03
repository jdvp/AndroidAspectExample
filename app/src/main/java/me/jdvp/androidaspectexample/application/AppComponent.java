package me.jdvp.androidaspectexample.application;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import me.jdvp.androidaspectexample.aspect.AspectLogging;

/**
 * Component used to define the dependency modules that are used in the application
 *
 * Created by jdvp on 6/18/18.
 */
@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                AppModule.class,
                ViewsModule.class
        }
)
public interface AppComponent extends AndroidInjector<DaggerSetupApplication> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<DaggerSetupApplication> {
    }

    void inject(AspectLogging aspectLogging);
}
