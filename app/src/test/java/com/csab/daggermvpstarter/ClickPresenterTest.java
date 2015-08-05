package com.csab.daggermvpstarter;

import com.csab.daggermvpstarter.mvp.presenter.ClickPresenterImpl;
import com.csab.daggermvpstarter.mvp.view.ClickView;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ClickPresenterTest {

    ClickView view = Mockito.mock(ClickView.class);
    ClickPresenterImpl presenter = new ClickPresenterImpl(view);

    @Test
    public void presenterResumeTest() {
        presenter.resume();
        verify(view).setCountText(String.valueOf(0));
    }

    @Test
    public void presenterClickTest() {
        presenter.buttonClick();
        verify(view).showToast("Clicked!");
    }
}
