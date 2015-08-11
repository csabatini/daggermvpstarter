package com.csab.daggermvpstarter.mvp.presenter;

import com.csab.daggermvpstarter.mvp.view.NoteListView;

public class NoteListPresenterImpl implements NoteListPresenter {

    private NoteListView view;

    public NoteListPresenterImpl(NoteListView view) {
        this.view = view;
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
    }
}
