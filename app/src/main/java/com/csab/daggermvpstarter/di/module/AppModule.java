package com.csab.daggermvpstarter.di.module;

import android.content.Context;

import com.csab.daggermvpstarter.App;
import com.csab.daggermvpstarter.rx.AppSchedulers;

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
    public Context provideAppContext() {
        return this.app;
    }

    @Provides
    @Singleton
    public AppSchedulers provideAppSchedulers() {
        return AppSchedulers.newLiveInstance();
    }

}
