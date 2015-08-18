package com.csab.daggermvpstarter.data;

import android.content.ContentValues;

import com.csab.daggermvpstarter.mvp.model.Note;
import com.squareup.sqlbrite.BriteDatabase;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class NoteInteractorImpl implements NoteInteractor {

    @Inject
    BriteDatabase db;

    @Inject
    public NoteInteractorImpl(BriteDatabase db) {
    }

    public void createNote(String text) {
        Note note = new Note(text);
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COL_CONTENTS, note.getContents());
        values.put(DatabaseHelper.COL_CREATED_DATE, note.getCreatedDate().toString());
        db.insert(DatabaseHelper.NOTE_TABLE, values);
    }

    public Observable<List<Note>> getNotes() {
        return db.createQuery(DatabaseHelper.NOTE_TABLE, "SELECT * FROM " + DatabaseHelper.NOTE_TABLE)
                .map(DataMapper.NOTE_MAP);
    }
}
