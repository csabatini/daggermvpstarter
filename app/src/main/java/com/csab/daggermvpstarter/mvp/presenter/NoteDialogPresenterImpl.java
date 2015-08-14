package com.csab.daggermvpstarter.mvp.presenter;

import com.csab.daggermvpstarter.data.NoteRepo;
import com.csab.daggermvpstarter.mvp.model.Note;
import com.csab.daggermvpstarter.mvp.view.NoteDialogView;

import javax.inject.Inject;

public class NoteDialogPresenterImpl implements NoteDialogPresenter {

    @Inject
    NoteDialogView view;
    @Inject
    NoteRepo repo;

    public NoteDialogPresenterImpl() {
    }

    @Inject
    public NoteDialogPresenterImpl(NoteDialogView view, NoteRepo repo) {
    }

    @Override
    public void create() {
        view.createDialog();
    }

    @Override
    public void resume() {

    }

    @Override
    public void saveClick() {
        String text = view.captureInputText();
        // use interactor for logic
        repo.putNote(new Note(text));
        view.dismissDialog();
    }

    @Override
    public void cancelClick() {
        view.dismissDialog();
    }

    public void setView(NoteDialogView view) {
        this.view = view;
    }

    public void setRepo(NoteRepo repo) {
        this.repo = repo;
    }
}
