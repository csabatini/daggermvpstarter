package com.csab.daggermvpstarter.di.module;

import com.csab.daggermvpstarter.mvp.presenter.NoteListPresenter;
import com.csab.daggermvpstarter.mvp.presenter.NoteListPresenterImpl;
import com.csab.daggermvpstarter.mvp.view.NoteListView;

import dagger.Module;
import dagger.Provides;

@Module
public class NoteModule {

    private NoteListView view;

    public NoteModule(NoteListView view) {
        this.view = view;
    }

    @Provides
    public NoteListView provideView() {
        return view;
    }

    @Provides
    public NoteListPresenter providePresenter(NoteListView view) {
        return new NoteListPresenterImpl(view);
    }
}
