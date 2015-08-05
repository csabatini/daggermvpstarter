package com.csab.daggermvpstarter.di;

import com.csab.daggermvpstarter.App;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                AppModule.class
        }
)
public interface AppComponent {
    void inject(App app);
}
