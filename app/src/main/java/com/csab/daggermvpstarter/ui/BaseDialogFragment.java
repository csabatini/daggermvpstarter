package com.csab.daggermvpstarter.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

import com.csab.daggermvpstarter.di.component.AppComponent;
import com.csab.daggermvpstarter.di.module.ActivityModule;

public abstract class BaseDialogFragment extends DialogFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupGraph(getAppComponent(), getActivityModule());
    }

    protected AppComponent getAppComponent() {
        return ((BaseActivity) getActivity()).getAppComponent();
    }

    protected ActivityModule getActivityModule() {
        return ((BaseActivity) getActivity()).getActivityModule();
    }

    protected abstract void setupGraph(AppComponent appComponent, ActivityModule activityModule);

}
