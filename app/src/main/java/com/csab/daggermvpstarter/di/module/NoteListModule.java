package com.csab.daggermvpstarter.di.module;

import android.app.Activity;

import com.csab.daggermvpstarter.adapter.NoteRecyclerAdapter;
import com.csab.daggermvpstarter.mvp.interactor.NoteInteractor;
import com.csab.daggermvpstarter.mvp.interactor.NoteInteractorImpl;
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
    public NoteInteractor provideInteractor(NoteInteractorImpl interactor) {
        return interactor;
    }

    @Provides @ActivityScope
    public NoteListPresenter providePresenter(NoteListPresenterImpl presenter) { return presenter; }

    @Provides @ActivityScope
    public NoteRecyclerAdapter provideAdapter(Activity activity, NoteListPresenter presenter) {
        return new NoteRecyclerAdapter(activity, presenter);
    }

}
