package com.csab.daggermvpstarter.mvp.view;

import com.csab.daggermvpstarter.mvp.model.Note;

import java.util.List;

public interface NoteListView {
    void showNotes(List<Note> notes);
    void showToast(String message);
    void showDialog();
}
