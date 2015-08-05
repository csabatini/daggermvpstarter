package com.csab.daggermvpstarter.mvp.presenter;

import com.csab.daggermvpstarter.mvp.view.ClickView;

public class ClickPresenterImpl implements ClickPresenter {

    private ClickView clickView;

    public ClickPresenterImpl(ClickView clickView) {
        this.clickView = clickView;
    }

    @Override
    public void resume() {
        clickView.setCountText(String.valueOf(0));
    }

    @Override
    public void pause() {

    }

    @Override
    public void buttonClick() {
        clickView.showToast("Clicked!");
    }
}
