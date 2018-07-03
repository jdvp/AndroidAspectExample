package me.jdvp.androidaspectexample.application;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import me.jdvp.androidaspectexample.activity.MainActivity;

/**
 * Module that defines which views will be injected
 *
 * Created by jdvp on 6/18/18.
 */
@Module
abstract class ViewsModule {
    @ContributesAndroidInjector
    abstract MainActivity mainActivity();
}