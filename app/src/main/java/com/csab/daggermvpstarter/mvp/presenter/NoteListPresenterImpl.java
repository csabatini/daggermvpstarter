package com.csab.daggermvpstarter.mvp.presenter;

import com.csab.daggermvpstarter.data.NoteRepo;
import com.csab.daggermvpstarter.mvp.model.Note;
import com.csab.daggermvpstarter.mvp.view.NoteListView;

import java.util.List;

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
        List<Note> notes = repo.getNotes();
        view.showNotes(notes);
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
