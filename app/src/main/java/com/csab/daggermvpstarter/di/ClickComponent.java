package com.csab.daggermvpstarter.di;

import com.csab.daggermvpstarter.mvp.presenter.ClickPresenter;
import com.csab.daggermvpstarter.ui.ClickActivity;

import dagger.Component;

@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = ClickModule.class
)
public interface ClickComponent {
    void inject(ClickActivity activity);
    ClickPresenter getClickPresenter();
}
