package com.csab.daggermvpstarter.mvp.presenter;

import android.util.Log;

import com.csab.daggermvpstarter.mvp.view.NoteDialogView;

import javax.inject.Inject;

public class NoteDialogPresenterImpl implements NoteDialogPresenter {

    @Inject
    NoteDialogView view;

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
        Log.d("DialogPresenter", "Save clicked!");
        String text = view.captureInputText();
        // use interactor for logic
        Log.d("DialogPresenter", text);
        view.dismissDialog();
    }

    @Override
    public void cancelClick() {
        Log.d("DialogPresenter", "Cancel clicked!");
        view.dismissDialog();
    }

}
