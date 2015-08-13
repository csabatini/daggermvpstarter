package com.csab.daggermvpstarter.data;

import android.content.SharedPreferences;
import android.util.Log;

import com.csab.daggermvpstarter.mvp.model.Note;
import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

public class NoteRepoImpl implements NoteRepo {

    @Inject
    SharedPreferences prefs;
    @Inject
    Gson gson;

    @Inject
    public NoteRepoImpl(SharedPreferences pref, Gson gson) {
    }

    @Override
    public void putNote(Note note) {
    }

    @Override
    public List<Note> getNotes() {
        return null;
    }
}
