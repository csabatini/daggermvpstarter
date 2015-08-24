package com.csab.daggermvpstarter;

import android.app.Application;

import com.csab.daggermvpstarter.di.component.AppComponent;
import com.csab.daggermvpstarter.di.component.DaggerAppComponent;
import com.csab.daggermvpstarter.di.module.AppModule;
import com.csab.daggermvpstarter.di.module.DbModule;
import com.csab.daggermvpstarter.rx.RxAndroidTestingSchedulersHook;
import com.csab.daggermvpstarter.rx.RxJavaTestingSchedulersHook;
import com.squareup.leakcanary.LeakCanary;

import rx.android.plugins.RxAndroidPlugins;
import rx.plugins.RxJavaPlugins;
import timber.log.Timber;

public class App extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        setupGraph();
        LeakCanary.install(this);
        if (BuildConfig.DEBUG) {
            RxAndroidPlugins.getInstance().registerSchedulersHook(new RxAndroidTestingSchedulersHook());
            RxJavaPlugins.getInstance().registerSchedulersHook(new RxJavaTestingSchedulersHook());
            Timber.plant(new Timber.DebugTree());
        }
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
