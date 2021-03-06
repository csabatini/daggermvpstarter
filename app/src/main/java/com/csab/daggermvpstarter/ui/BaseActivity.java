package com.csab.daggermvpstarter.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.csab.daggermvpstarter.App;
import com.csab.daggermvpstarter.R;
import com.csab.daggermvpstarter.di.component.AppComponent;
import com.csab.daggermvpstarter.di.module.ActivityModule;

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        getAppComponent().inject(this);
        initializeToolbar();
    }

    protected void addFragment(int containerId, Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(containerId, fragment)
                .commit();
    }

    protected AppComponent getAppComponent() {
        return ((App) getApplicationContext()).getComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    protected abstract int getLayoutId();

    private void initializeToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }
}
