package com.csab.daggermvpstarter.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.csab.daggermvpstarter.App;
import com.squareup.otto.Bus;

import javax.inject.Inject;

public abstract class BaseActivity extends ActionBarActivity {

    @Inject
    Bus mBus;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getApplicationContext()).getComponent().inject(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mBus.register(this );
    }

    @Override
    public void onPause() {
        super.onPause();
        mBus.unregister(this);
    }

    protected void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    protected void addFragment(int containerId, Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(containerId, fragment)
                .commit();
    }

//    protected ActivityModule getActivityModule() {
//        return new ActivityModule(this);
//    }

}
