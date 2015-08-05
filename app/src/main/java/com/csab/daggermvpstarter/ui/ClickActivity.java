package com.csab.daggermvpstarter.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.csab.daggermvpstarter.R;
import com.csab.daggermvpstarter.di.AppComponent;
import com.csab.daggermvpstarter.di.ClickModule;
import com.csab.daggermvpstarter.di.DaggerClickComponent;
import com.csab.daggermvpstarter.mvp.presenter.ClickPresenter;
import com.csab.daggermvpstarter.mvp.view.ClickView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ClickActivity extends BaseActivity implements ClickView, View.OnClickListener {

    @Inject
    ClickPresenter mPresenter;

    @Bind(R.id.countText)
    TextView mCountText;
    @Bind(R.id.countButton)
    Button mCountButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);
        ButterKnife.bind(this);
        mCountButton.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.resume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setCountText(String text) {
        mCountText.setText(text);
    }

    @Override
    public void onClick(View view) {
        mPresenter.buttonClick();
    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerClickComponent.builder()
                .appComponent(appComponent)
                .clickModule(new ClickModule(this))
                .build()
                .inject(this);
    }
}
