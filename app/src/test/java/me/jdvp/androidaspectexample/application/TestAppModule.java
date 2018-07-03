package me.jdvp.androidaspectexample.application;


import dagger.Module;
import me.jdvp.androidaspectexample.viewmodel.impl.TestViewModelModule;

/**
 * Test module that mirrors AppModule but mocks the dependencies
 *
 * Created by jdvp on 6/19/18.
 */
@Module(
        includes = TestViewModelModule.class
)
class TestAppModule {
}
