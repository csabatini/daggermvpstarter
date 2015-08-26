package com.csab.daggermvpstarter.mvp.interactor;

import android.content.ContentValues;
import android.database.Cursor;

import com.csab.daggermvpstarter.data.DatabaseHelper;
import com.csab.daggermvpstarter.mvp.model.Note;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

public class NoteInteractorImpl implements NoteInteractor {

    @Inject
    BriteDatabase db;

    @Inject
    public NoteInteractorImpl(BriteDatabase db) {
    }

    public void createNote(String text) {
        Note note = new Note(text, newDateString());
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COL_CONTENTS, note.getContents());
        values.put(DatabaseHelper.COL_CREATED_DATE, note.getCreatedDate());
        db.insert(DatabaseHelper.NOTE_TABLE, values);
    }

    public Observable<List<Note>> getNotes() {
        return db.createQuery(DatabaseHelper.NOTE_TABLE, "SELECT * FROM " + DatabaseHelper.NOTE_TABLE)
                .map(NOTE_MAP);
    }

    private static String newDateString() {
        return DateTime.now().toString();
    }

    public static final Func1<SqlBrite.Query, List<Note>> NOTE_MAP = new Func1<SqlBrite.Query, List<Note>>() {
        @Override
        public List<Note> call(SqlBrite.Query query) {
            List<Note> notes = new ArrayList<>();
            Cursor cursor = query.run();
            try {
                while (cursor.moveToNext()) {
                    Integer id =
                            cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_ID));
                    String contents =
                            cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_CONTENTS));
                    String createdDate =
                            cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_CREATED_DATE));
                    notes.add(new Note(id, contents, createdDate));
                }
            } finally {
                cursor.close();
            }
            return notes;
        }
    };
}
