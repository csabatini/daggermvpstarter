package com.csab.daggermvpstarter.di.module;

import com.csab.daggermvpstarter.di.ActivityScope;
import com.csab.daggermvpstarter.mvp.presenter.NoteListPresenter;
import com.csab.daggermvpstarter.mvp.presenter.NoteListPresenterImpl;
import com.csab.daggermvpstarter.mvp.view.NoteListView;

import dagger.Module;
import dagger.Provides;

@Module
public class NoteFragmentModule {

    private NoteListView view;

    public NoteFragmentModule(NoteListView view) {
        this.view = view;
    }

    @Provides @ActivityScope
    public NoteListView provideView() {
        return view;
    }

    @Provides @ActivityScope
    public NoteListPresenter providePresenter(NoteListView view) {
        return new NoteListPresenterImpl(view);
    }
}
