package com.csab.daggermvpstarter.mvp.presenter;

public interface NoteListPresenter {
    void resume();
    void pause();
    void buttonClick();
    void noteSwipe(int position, String direction);
}
