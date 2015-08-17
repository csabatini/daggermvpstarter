package com.csab.daggermvpstarter;

import android.app.Application;

import com.csab.daggermvpstarter.di.component.AppComponent;
import com.csab.daggermvpstarter.di.component.DaggerAppComponent;
import com.csab.daggermvpstarter.di.module.AppModule;
import com.csab.daggermvpstarter.di.module.DbModule;

public class App extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        setupGraph();
    }

    private void setupGraph() {
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .dbModule(new DbModule())
                .build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
