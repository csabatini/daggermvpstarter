package com.csab.daggermvpstarter;


import com.csab.daggermvpstarter.data.NoteInteractor;
import com.csab.daggermvpstarter.mvp.presenter.NoteDialogPresenterImpl;
import com.csab.daggermvpstarter.mvp.view.NoteDialogView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class NoteDialogPresenterImplTest {

    @Mock
    private NoteDialogView view;
    @Mock
    private NoteInteractor interactor;
    private NoteDialogPresenterImpl presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new NoteDialogPresenterImpl(view, interactor);
    }

    @Test
    public void presenterCreateInstantiatesDialogTest() {
        presenter.create();
        verify(view).createDialog();
        verifyNoMoreInteractions(view);
    }

    @Test
    public void presenterSaveClickCapturesTextAndDismissesTest() {
        String text = "test!";
        when(view.captureInputText()).thenReturn(text);

        presenter.saveClick();
        verify(view).captureInputText();
        verify(interactor).createNote(text);
        verify(view).dismissDialog();
        verifyNoMoreInteractions(view);
        verifyNoMoreInteractions(interactor);
    }

    @Test
    public void presenterCancelClickDismissesDialogTest(){
        presenter.cancelClick();
        verify(view).dismissDialog();
        verifyNoMoreInteractions(view);
    }
}
