package com.csab.daggermvpstarter;

import com.csab.daggermvpstarter.data.NoteInteractor;
import com.csab.daggermvpstarter.mvp.model.Note;
import com.csab.daggermvpstarter.mvp.presenter.NoteListPresenterImpl;
import com.csab.daggermvpstarter.mvp.view.NoteListView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class NoteListPresenterImplTest {

    @Mock
    private NoteListView view;
    @Mock
    private NoteInteractor interactor;

    private NoteListPresenterImpl presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new NoteListPresenterImpl(view, interactor);
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
    public void presenterNoteClickShowsToast() {
        presenter.noteClick(1);
        verify(view).showSnack(R.string.note_clicked);
        verifyNoMoreInteractions(view);
    }

}
