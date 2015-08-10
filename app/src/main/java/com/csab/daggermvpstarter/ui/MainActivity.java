package com.csab.daggermvpstarter.ui;

import android.os.Bundle;

import com.csab.daggermvpstarter.R;
import com.csab.daggermvpstarter.di.component.DaggerActivityComponent;
import com.csab.daggermvpstarter.di.module.ActivityModule;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment(R.id.container, new NoteListFragment());
    }

    private void initializeInjector() {
        DaggerActivityComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }
}
