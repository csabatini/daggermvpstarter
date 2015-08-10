package com.csab.daggermvpstarter.di.component;

import android.app.Activity;

import com.csab.daggermvpstarter.di.ActivityScope;
import com.csab.daggermvpstarter.di.module.ActivityModule;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}
