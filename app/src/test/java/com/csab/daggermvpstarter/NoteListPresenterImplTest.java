package com.csab.daggermvpstarter;

import com.csab.daggermvpstarter.data.NoteInteractor;
import com.csab.daggermvpstarter.mvp.model.Note;
import com.csab.daggermvpstarter.mvp.presenter.NoteListPresenterImpl;
import com.csab.daggermvpstarter.mvp.view.NoteListView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class NoteListPresenterImplTest {

    private NoteListView view;
    private NoteInteractor interactor;
    private NoteListPresenterImpl presenter;

    @Before
    public void setup() {
        view = Mockito.mock(NoteListView.class);
        interactor = Mockito.mock(NoteInteractor.class);
        presenter = new NoteListPresenterImpl();
        presenter.setView(view);
        presenter.setInteractor(interactor);
    }

    @Test
    public void presenterResumeFetchesNotesTest() {
        List<Note> notes = new ArrayList<>();
        when(interactor.getNotes()).thenReturn(Observable.just(notes));
        presenter.resume();
        verify(view).showNotes(notes);
    }

    @Test
    public void presenterButtonClickShowsDialogTest() {
        presenter.buttonClick();
        verify(view).showDialog();
        verifyNoMoreInteractions(view);
        verifyNoMoreInteractions(interactor);
    }

}
