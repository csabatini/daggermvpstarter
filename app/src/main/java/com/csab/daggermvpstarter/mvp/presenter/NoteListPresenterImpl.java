package com.csab.daggermvpstarter.mvp.presenter;

import com.csab.daggermvpstarter.mvp.interactor.NoteInteractor;
import com.csab.daggermvpstarter.mvp.model.Note;
import com.csab.daggermvpstarter.mvp.view.NoteListView;
import com.csab.daggermvpstarter.rx.AppSchedulers;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import timber.log.Timber;

public class NoteListPresenterImpl extends RxPresenter implements NoteListPresenter {

    private NoteListView view;
    private NoteInteractor interactor;
    private AppSchedulers schedulers;

    @Inject
    public NoteListPresenterImpl(NoteListView view, NoteInteractor interactor,
                                 AppSchedulers schedulers) {
        this.view = view;
        this.interactor = interactor;
        this.schedulers = schedulers;
    }

    @Override
    public void resume() {
        Timber.d("resume - subscribing!");
        add(interactor.getNotes()
                .compose(this.<List<Note>>applySchedulers(schedulers))
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
    public void noteSwipe(int position, String direction) {
        view.showSnack("Position " + position + " swiped " + direction + "!");
        view.removeNoteFromList(position);
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
