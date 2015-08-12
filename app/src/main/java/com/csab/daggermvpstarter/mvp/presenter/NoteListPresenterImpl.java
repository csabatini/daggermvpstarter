package com.csab.daggermvpstarter.mvp.presenter;

import com.csab.daggermvpstarter.data.NoteRepo;
import com.csab.daggermvpstarter.mvp.view.NoteListView;

import javax.inject.Inject;

public class NoteListPresenterImpl implements NoteListPresenter {

    @Inject
    NoteListView view;
    @Inject
    NoteRepo repo;

    @Inject
    public NoteListPresenterImpl(NoteListView view, NoteRepo repo) {
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void buttonClick() {
        view.showDialog();
        repo.log("Test logging click");
    }
}
