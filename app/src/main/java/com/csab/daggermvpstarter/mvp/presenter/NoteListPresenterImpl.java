package com.csab.daggermvpstarter.mvp.presenter;

import com.csab.daggermvpstarter.mvp.view.NoteListView;

public class NoteListPresenterImpl implements NoteListPresenter {

    private NoteListView clickView;

    public NoteListPresenterImpl(NoteListView clickView) {
        this.clickView = clickView;
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void buttonClick() {
        clickView.showToast("Clicked!");
    }
}
