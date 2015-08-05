package com.csab.daggermvpstarter.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.csab.daggermvpstarter.App;
import com.csab.daggermvpstarter.di.AppComponent;

public abstract class BaseActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent(((App) getApplicationContext()).getComponent());
    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    protected abstract void setupComponent(AppComponent component);
}
