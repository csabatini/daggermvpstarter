package com.csab.daggermvpstarter.di;

import com.csab.daggermvpstarter.mvp.presenter.ClickPresenter;
import com.csab.daggermvpstarter.mvp.presenter.ClickPresenterImpl;
import com.csab.daggermvpstarter.mvp.view.ClickView;

import dagger.Module;
import dagger.Provides;

@Module
public class ClickModule {

    private ClickView view;

    public ClickModule(ClickView view) {
        this.view = view;
    }

    @Provides
    public ClickView provideView() {
        return view;
    }

    @Provides
    public ClickPresenter providePresenter(ClickView clickView) {
        return new ClickPresenterImpl(clickView);
    }
}
