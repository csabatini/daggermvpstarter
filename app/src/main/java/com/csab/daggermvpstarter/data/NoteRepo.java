package com.csab.daggermvpstarter.data;

import com.csab.daggermvpstarter.mvp.model.Note;

import java.util.List;

public interface NoteRepo {
    void log(String msg);
    void putNote(Note note);
    List<Note> getNotes();
}
