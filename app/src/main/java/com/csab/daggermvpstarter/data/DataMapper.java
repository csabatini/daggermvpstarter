package com.csab.daggermvpstarter.data;

import android.database.Cursor;

import com.csab.daggermvpstarter.mvp.model.Note;
import com.squareup.sqlbrite.SqlBrite.Query;

import java.util.ArrayList;
import java.util.List;

import rx.functions.Func1;

public class DataMapper {

    private DataMapper() {
    }

    public static final Func1<Query, List<Note>> NOTE_MAP = new Func1<Query, List<Note>>() {
        @Override
        public List<Note> call(Query query) {
            List<Note> notes = new ArrayList<>();
            Cursor cursor = query.run();
            try {
                while (cursor.moveToNext()) {
                    String contents =
                            cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_CONTENTS));
                    String createdDate =
                            cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_CREATED_DATE));
                    notes.add(new Note(contents));
                }
            } finally {
                cursor.close();
            }
            return notes;
        }
    };
}
