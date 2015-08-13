package com.csab.daggermvpstarter.mvp.presenter;

import com.csab.daggermvpstarter.data.NoteRepo;
import com.csab.daggermvpstarter.mvp.view.NoteListView;

import javax.inject.Inject;

public class NoteListPresenterImpl implements NoteListPresenter {

    @Inject
    NoteListView view;
    @Inject
    NoteRepo repo;

    public NoteListPresenterImpl() {
    }

    @Inject
    public NoteListPresenterImpl(NoteListView view, NoteRepo repo) {
    }

    @Override
    public void resume() {
        repo.getNotes();
    }

    @Override
    public void pause() {
    }

    @Override
    public void buttonClick() {
        view.showDialog();
    }

    public void setView(NoteListView view) {
        this.view = view;
    }
    public void setRepo(NoteRepo repo) {
        this.repo = repo;
    }
}
