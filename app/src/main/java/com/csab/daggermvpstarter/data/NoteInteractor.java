package com.csab.daggermvpstarter.data;

import com.csab.daggermvpstarter.mvp.model.Note;

import java.util.List;

import rx.Observable;

public interface NoteInteractor {
    void createNote(String text);
    Observable<List<Note>> getNotes();
}
