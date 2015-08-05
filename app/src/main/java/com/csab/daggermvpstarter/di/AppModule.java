package com.csab.daggermvpstarter.di;

import android.content.Context;

import com.csab.daggermvpstarter.App;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return this.app;
    }

    @Provides
    @Singleton
    public Bus provideBus() {
        return new Bus();
    }
}