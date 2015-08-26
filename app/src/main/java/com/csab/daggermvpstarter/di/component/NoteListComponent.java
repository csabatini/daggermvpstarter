package com.csab.daggermvpstarter.di.component;

import com.csab.daggermvpstarter.adapter.NoteRecyclerAdapter;
import com.csab.daggermvpstarter.mvp.interactor.NoteInteractor;
import com.csab.daggermvpstarter.di.ActivityScope;
import com.csab.daggermvpstarter.di.module.ActivityModule;
import com.csab.daggermvpstarter.di.module.NoteListModule;
import com.csab.daggermvpstarter.mvp.presenter.NoteListPresenter;
import com.csab.daggermvpstarter.mvp.view.NoteListView;
import com.csab.daggermvpstarter.ui.NoteListFragment;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, NoteListModule.class})
public interface NoteListComponent extends ActivityComponent {
    void inject(NoteListFragment noteListFragment);
    NoteListView view();
    NoteListPresenter presenter();
    NoteRecyclerAdapter adapter();
    NoteInteractor interactor();
}
