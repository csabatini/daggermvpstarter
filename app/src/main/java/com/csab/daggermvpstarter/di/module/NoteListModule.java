package com.csab.daggermvpstarter.di.module;

import com.csab.daggermvpstarter.adapter.NoteRecyclerAdapter;
import com.csab.daggermvpstarter.data.NoteRepo;
import com.csab.daggermvpstarter.data.NoteRepoImpl;
import com.csab.daggermvpstarter.di.ActivityScope;
import com.csab.daggermvpstarter.mvp.presenter.NoteListPresenter;
import com.csab.daggermvpstarter.mvp.presenter.NoteListPresenterImpl;
import com.csab.daggermvpstarter.mvp.view.NoteListView;

import dagger.Module;
import dagger.Provides;

@Module
public class NoteListModule {

    private NoteListView view;

    public NoteListModule(NoteListView view) {
        this.view = view;
    }

    @Provides @ActivityScope
    public NoteListView provideView() {
        return view;
    }

    @Provides @ActivityScope
    public NoteRepo provideRepo(NoteRepoImpl repo) {
        return repo;
    }

    @Provides @ActivityScope
    public NoteListPresenter providePresenter(NoteListPresenterImpl presenter) { return presenter; }

}
