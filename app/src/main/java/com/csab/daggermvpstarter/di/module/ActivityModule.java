package com.csab.daggermvpstarter.di.module;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;

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
    public Activity provideActivityContext() {
        return this.activity;
    }

    @Provides @ActivityScope
    public LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(activity);
    }

}
