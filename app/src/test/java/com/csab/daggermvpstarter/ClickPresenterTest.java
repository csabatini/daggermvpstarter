package com.csab.daggermvpstarter;

import com.csab.daggermvpstarter.mvp.presenter.NoteListPresenterImpl;
import com.csab.daggermvpstarter.mvp.view.NoteListView;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class ClickPresenterTest {

    NoteListView view = Mockito.mock(NoteListView.class);
    NoteListPresenterImpl presenter = new NoteListPresenterImpl(view);

    @Test
    public void presenterClickTest() {
        presenter.buttonClick();
        verify(view).showToast("Clicked!");
    }
}
