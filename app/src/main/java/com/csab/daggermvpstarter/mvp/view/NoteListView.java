package com.csab.daggermvpstarter.mvp.view;

import com.csab.daggermvpstarter.mvp.model.Note;

import java.util.List;

public interface NoteListView {
    void showNotes(List<Note> notes);
    void showToast(String message);
    void showSnack(String message);
    void showDialog();
    void removeNoteFromList(int position);
}
