package com.csab.daggermvpstarter.di;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule (Activity activity) {
        this.activity = activity;
    }

    @Provides @ActivityScope
    Context providesActivityContext(Context context) {
        return this.activity;
    }
}
