package com.csab.daggermvpstarter.data;

import com.csab.daggermvpstarter.mvp.model.Note;

import java.util.List;

public interface NoteRepo {
    void createNote(String text);
    List<Note> getNotes();
}
