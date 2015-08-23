package com.csab.daggermvpstarter.mvp.presenter;

import com.csab.daggermvpstarter.R;
import com.csab.daggermvpstarter.data.NoteInteractor;
import com.csab.daggermvpstarter.mvp.model.Note;
import com.csab.daggermvpstarter.mvp.view.NoteListView;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class NoteListPresenterImpl extends RxPresenter implements NoteListPresenter {

    private NoteListView view;
    private NoteInteractor interactor;

    @Inject
    public NoteListPresenterImpl(NoteListView view, NoteInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void resume() {
        Timber.d("resume - subscribing!");
        add(interactor.getNotes()
                .subscribeOn(Schedulers.io())
                // TODO: get schedulers hook working with AndroidSchedulers
                //.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new NoteSubscriber()));
    }

    @Override
    public void pause() {
        Timber.d("pause - unsubscribing!");
        unsubscribe();
    }

    @Override
    public void buttonClick() {
        view.showDialog();
    }

    @Override
    public void noteClick(int position) {
        view.showSnack(R.string.note_clicked);
    }

    public class NoteSubscriber extends Subscriber<List<Note>> {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            Timber.e(e, "onError retrieving notes");
            view.showToast("Error loading notes");
        }

        @Override
        public void onNext(List<Note> notes) {
            Timber.d("onNext with list size %d", notes.size());
            view.showNotes(notes);
        }
    }

}
