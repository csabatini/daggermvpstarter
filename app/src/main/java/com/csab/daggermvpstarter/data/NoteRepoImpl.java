package com.csab.daggermvpstarter.data;

import android.content.SharedPreferences;

import com.csab.daggermvpstarter.mvp.model.Note;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
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
        List<Note> notes = getNotes();
        notes.add(note);

        String json = gson.toJson(notes, new TypeToken<List<Note>>(){}.getType());
        putSerializedPreferenceString(json);
    }

    @Override
    public List<Note> getNotes() {
        String json = getSerializedPreferenceString();
        if (json.isEmpty()) {
            return new ArrayList<Note>();
        } else {
            return gson.fromJson(json, new TypeToken<List<Note>>(){}.getType());
        }
    }

    private String getSerializedPreferenceString() {
        return prefs.getString("notes", "");
    }

    private void putSerializedPreferenceString(String json) {
        prefs.edit()
             .putString("notes", json)
             .apply();
    }
}
