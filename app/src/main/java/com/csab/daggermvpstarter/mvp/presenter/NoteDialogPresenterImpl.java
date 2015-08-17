package com.csab.daggermvpstarter.mvp.presenter;

import com.csab.daggermvpstarter.data.NoteInteractor;
import com.csab.daggermvpstarter.mvp.view.NoteDialogView;

import javax.inject.Inject;

public class NoteDialogPresenterImpl implements NoteDialogPresenter {

    @Inject
    NoteDialogView view;
    @Inject
    NoteInteractor interactor;

    public NoteDialogPresenterImpl() {
    }

    @Inject
    public NoteDialogPresenterImpl(NoteDialogView view) {
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
        interactor.createNote(text);
        view.dismissDialog();
    }

    @Override
    public void cancelClick() {
        view.dismissDialog();
    }

    public void setView(NoteDialogView view) {
        this.view = view;
    }

}
