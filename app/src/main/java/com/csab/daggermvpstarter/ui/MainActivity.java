package com.csab.daggermvpstarter.ui;

import android.os.Bundle;

import com.csab.daggermvpstarter.R;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment(R.id.container, new NoteListFragment());
    }
}
