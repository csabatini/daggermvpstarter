package com.csab.daggermvpstarter;


import com.csab.daggermvpstarter.data.NoteRepo;
import com.csab.daggermvpstarter.mvp.model.Note;
import com.csab.daggermvpstarter.mvp.presenter.NoteDialogPresenterImpl;
import com.csab.daggermvpstarter.mvp.view.NoteDialogView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class NoteDialogPresenterImplTest {

    private NoteDialogView view;
    private NoteRepo repo;
    private NoteDialogPresenterImpl presenter;

    @Before
    public void setup() {
        view = Mockito.mock(NoteDialogView.class);
        repo = Mockito.mock(NoteRepo.class);
        presenter = new NoteDialogPresenterImpl();
        presenter.setView(view);
        presenter.setRepo(repo);
    }

    @Test
    public void presenterCreateInstantiatesDialogTest() {
        presenter.create();
        verify(view).createDialog();
        verifyNoMoreInteractions(view);
    }

    @Test
    public void presenterSaveClickCapturesTextAndDismissesTest() {
        presenter.saveClick();
        verify(view).captureInputText();
        verify(repo).putNote(any(Note.class));
        verify(view).dismissDialog();
        verifyNoMoreInteractions(view);
    }

    @Test
    public void presenterCancelClickDismissesDialogTest(){
        presenter.cancelClick();
        verify(view).dismissDialog();
        verifyNoMoreInteractions(view);
    }



}
