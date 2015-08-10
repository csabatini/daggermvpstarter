package com.csab.daggermvpstarter.mvp.view;

import java.util.List;

public interface NoteListView {

    void showNotes(List<String> notes);

    void showToast(String message);
}
