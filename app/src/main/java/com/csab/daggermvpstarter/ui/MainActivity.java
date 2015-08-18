package com.csab.daggermvpstarter.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.View;

import com.csab.daggermvpstarter.R;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fragment fragment =
                getSupportFragmentManager().findFragmentById(R.id.container);
        if (fragment == null)
            addFragment(R.id.container, new NoteListFragment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
}
