package com.csab.daggermvpstarter.di.module;

import android.app.Activity;

import com.csab.daggermvpstarter.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule (Activity activity) {
        this.activity = activity;
    }

    @Provides @ActivityScope
    Activity provideActivityContext() {
        return this.activity;
    }
}
