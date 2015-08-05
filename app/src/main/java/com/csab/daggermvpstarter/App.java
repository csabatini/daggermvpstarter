package com.csab.daggermvpstarter;

import android.app.Application;

import com.csab.daggermvpstarter.di.AppComponent;
import com.csab.daggermvpstarter.di.AppModule;
import com.csab.daggermvpstarter.di.DaggerAppComponent;

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
                .build();
        component.inject(this);
    }

    public AppComponent getComponent() {
        return component;
    }


}
