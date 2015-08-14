package com.csab.daggermvpstarter.di.module;

import com.csab.daggermvpstarter.data.NoteRepo;
import com.csab.daggermvpstarter.data.NoteRepoImpl;
import com.csab.daggermvpstarter.di.ActivityScope;
import com.csab.daggermvpstarter.mvp.presenter.NoteDialogPresenter;
import com.csab.daggermvpstarter.mvp.presenter.NoteDialogPresenterImpl;
import com.csab.daggermvpstarter.mvp.view.NoteDialogView;

import dagger.Module;
import dagger.Provides;

@Module
public class NoteDialogModule {

    private NoteDialogView view;

    public NoteDialogModule(NoteDialogView view) {
        this.view = view;
    }

    @Provides @ActivityScope
    public NoteDialogView provideView() {
        return view;
    }

    @Provides @ActivityScope
    public NoteRepo provideRepo(NoteRepoImpl repo) {
        return repo;
    }

    @Provides @ActivityScope
    public NoteDialogPresenter providePresenter(NoteDialogPresenterImpl presenter) {
        return presenter;
    }
}
