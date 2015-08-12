package com.csab.daggermvpstarter.di.component;

import com.csab.daggermvpstarter.di.ActivityScope;
import com.csab.daggermvpstarter.di.module.ActivityModule;
import com.csab.daggermvpstarter.di.module.NoteDialogModule;
import com.csab.daggermvpstarter.mvp.presenter.NoteDialogPresenter;
import com.csab.daggermvpstarter.mvp.view.NoteDialogView;
import com.csab.daggermvpstarter.ui.NoteDialogFragment;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, NoteDialogModule.class})
public interface NoteDialogComponent {
    void inject(NoteDialogFragment noteDialogFragment);
    NoteDialogView view();
    NoteDialogPresenter presenter();
}
