package com.csab.daggermvpstarter.mvp.presenter;

import com.csab.daggermvpstarter.data.NoteInteractor;
import com.csab.daggermvpstarter.mvp.model.Note;
import com.csab.daggermvpstarter.mvp.view.NoteListView;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NoteListPresenterImpl extends RxPresenter implements NoteListPresenter {

    @Inject
    NoteListView view;
    @Inject
    NoteInteractor interactor;

    public NoteListPresenterImpl() {
    }

    @Inject
    public NoteListPresenterImpl(NoteListView view, NoteInteractor interactor) {
    }

    @Override
    public void resume() {
        add(interactor.getNotes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new NoteSubscriber()));
    }

    @Override
    public void pause() {
        unsubscribe();
    }

    @Override
    public void buttonClick() {
        view.showDialog();
    }

    public void setView(NoteListView view) {
        this.view = view;
    }

    public void setInteractor(NoteInteractor interactor) { this.interactor = interactor; }

    private class NoteSubscriber extends Subscriber<List<Note>> {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            view.showToast("Error loading notes");
        }

        @Override
        public void onNext(List<Note> notes) {
            view.showNotes(notes);
        }
    }

}
