package com.csab.daggermvpstarter.di.module;

import android.content.Context;

import com.csab.daggermvpstarter.App;

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

}
