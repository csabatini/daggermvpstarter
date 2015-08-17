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

import static org.mockito.Mockito.*;

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
        /*
        TODO: update for interactor/rx
        List<Note> list = new ArrayList<>();

        when(repo.getNotes()).thenReturn(list);
        presenter.resume();
        verify(repo).getNotes();
        verify(view).showNotes(list);
        verifyNoMoreInteractions(view);
        verifyNoMoreInteractions(repo);
        */
    }

    @Test
    public void presenterButtonClickShowsDialogTest() {
        presenter.buttonClick();
        verify(view).showDialog();
        verifyNoMoreInteractions(view);
        verifyNoMoreInteractions(interactor);
    }

}
