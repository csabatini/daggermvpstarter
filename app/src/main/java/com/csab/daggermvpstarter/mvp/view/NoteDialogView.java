package com.csab.daggermvpstarter.mvp.view;

public interface NoteDialogView {
    void createDialog();
    void dismissDialog();
    void showToast(String message);
    String captureInputText();
}
