package com.csab.daggermvpstarter;

import com.csab.daggermvpstarter.data.NoteRepo;
import com.csab.daggermvpstarter.data.NoteRepoImpl;
import com.csab.daggermvpstarter.mvp.model.Note;
import com.csab.daggermvpstarter.mvp.presenter.NoteListPresenterImpl;
import com.csab.daggermvpstarter.mvp.view.NoteListView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class NoteListPresenterImplTest {

    private NoteListView view;
    private NoteRepo repo;
    private NoteListPresenterImpl presenter;

    @Before
    public void setup() {
        view = Mockito.mock(NoteListView.class);
        repo = Mockito.mock(NoteRepo.class);
        presenter = new NoteListPresenterImpl();
        presenter.setView(view);
        presenter.setRepo(repo);
    }

    @Test
    public void presenterResumeFetchesNotesTest() {
        List<Note> list = new ArrayList<>();

        when(repo.getNotes()).thenReturn(list);
        presenter.resume();
        verify(repo).getNotes();
        verify(view).showNotes(list);
        verifyNoMoreInteractions(view);
        verifyNoMoreInteractions(repo);
    }

    @Test
    public void presenterButtonClickShowsDialogTest() {
        presenter.buttonClick();
        verify(view).showDialog();
        verifyNoMoreInteractions(view);
        verifyNoMoreInteractions(repo);
    }

}
