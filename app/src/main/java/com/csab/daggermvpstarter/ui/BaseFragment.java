package com.csab.daggermvpstarter.ui;

import android.support.v4.app.Fragment;

import com.csab.daggermvpstarter.di.component.AppComponent;
import com.csab.daggermvpstarter.di.module.ActivityModule;

public abstract class BaseFragment extends Fragment {

    protected AppComponent getAppComponent() {
        return ((BaseActivity) getActivity()).getAppComponent();
    }

    protected ActivityModule getActivityModule() {
        return ((BaseActivity) getActivity()).getActivityModule();
    }

}
