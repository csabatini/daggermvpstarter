package com.csab.daggermvpstarter.mvp.presenter;

import com.csab.daggermvpstarter.mvp.interactor.NoteInteractor;
import com.csab.daggermvpstarter.mvp.view.NoteDialogView;

import javax.inject.Inject;

import timber.log.Timber;

public class NoteDialogPresenterImpl implements NoteDialogPresenter {

    private NoteDialogView view;
    private NoteInteractor interactor;

    @Inject
    public NoteDialogPresenterImpl(NoteDialogView view, NoteInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
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
}
