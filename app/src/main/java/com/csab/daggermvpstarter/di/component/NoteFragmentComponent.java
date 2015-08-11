package com.csab.daggermvpstarter.di.component;

import com.csab.daggermvpstarter.di.ActivityScope;
import com.csab.daggermvpstarter.di.module.ActivityModule;
import com.csab.daggermvpstarter.di.module.NoteFragmentModule;
import com.csab.daggermvpstarter.mvp.presenter.NoteListPresenterImpl;
import com.csab.daggermvpstarter.mvp.view.NoteListView;
import com.csab.daggermvpstarter.ui.NoteListFragment;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, NoteFragmentModule.class})
public interface NoteFragmentComponent extends ActivityComponent {
    void inject(NoteListFragment noteListFragment);
    NoteListView view();
    NoteListPresenterImpl presenter();
}
