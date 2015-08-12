package com.csab.daggermvpstarter.di.component;

import android.content.Context;
import android.content.SharedPreferences;

import com.csab.daggermvpstarter.di.module.AppModule;
import com.csab.daggermvpstarter.ui.BaseActivity;
import com.google.gson.Gson;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(BaseActivity activity);
    Context context();
    SharedPreferences preferences();
    Gson gson();
    Bus bus();

}
