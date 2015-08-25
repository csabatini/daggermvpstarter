package com.csab.daggermvpstarter;

import com.csab.daggermvpstarter.data.NoteInteractor;
import com.csab.daggermvpstarter.mvp.model.Note;
import com.csab.daggermvpstarter.mvp.presenter.NoteListPresenterImpl;
import com.csab.daggermvpstarter.mvp.view.NoteListView;
import com.csab.daggermvpstarter.rx.AppSchedulers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static org.mockito.Mockito.*;

public class NoteListPresenterImplTest {

    @Mock
    private NoteListView view;
    @Mock
    private NoteInteractor interactor;

    private NoteListPresenterImpl presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new NoteListPresenterImpl(view, interactor, AppSchedulers.newTestInstance());
    }

    @Test
    public void presenterResumeFetchesAndDisplaysNotesTest() {
        List<Note> notes = new ArrayList<>();
        when(interactor.getNotes()).thenReturn(Observable.just(notes));

        presenter.resume();
        verify(interactor).getNotes();
        verify(view).showNotes(notes);
        verifyNoMoreInteractions(interactor);
        verifyNoMoreInteractions(view);
    }

    @Test
    public void presenterButtonClickShowsDialogTest() {
        presenter.buttonClick();
        verify(view).showDialog();
        verifyNoMoreInteractions(view);
        verifyNoMoreInteractions(interactor);
    }

    @Test
    public void presenterVerifySwipeShowsSnackRemovesNote() {
        presenter.noteSwipe(0, Constants.DIRECTION_LEFT);
        verify(view).showSnack("Position 0 swiped LEFT!");
        verify(view).removeNoteFromList(0);
        presenter.noteSwipe(1, Constants.DIRECTION_RIGHT);
        verify(view).showSnack("Position 1 swiped RIGHT!");
        verify(view).removeNoteFromList(1);
        verifyNoMoreInteractions(view);
    }

}
