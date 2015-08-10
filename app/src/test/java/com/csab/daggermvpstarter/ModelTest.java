package com.csab.daggermvpstarter;

import com.csab.daggermvpstarter.mvp.model.Note;
import com.csab.daggermvpstarter.mvp.presenter.NoteListPresenterImpl;
import com.csab.daggermvpstarter.mvp.view.NoteListView;
import com.google.gson.Gson;
import java.util.*;

import org.junit.Test;
import org.mockito.Mockito;
import org.ocpsoft.prettytime.PrettyTime;

public class ModelTest {

    @Test
    public void modelSerializationTest() {
        Gson gson = new Gson();
        Note note = new Note("Hello, world!");
        System.out.println(gson.toJson(note, Note.class));
    }

    @Test
    public void modelTimeFormattingTest1() {
        Note note = new Note("Hello, world!");
        PrettyTime prettyTime = new PrettyTime();
        System.out.println(prettyTime.format(note.getCreatedDate()));
    }

    @Test
    public void modelTimeFormattingTest2() {
        long minusMs = 1000 * 60 * 5;
        Date date = new Date(System.currentTimeMillis() - minusMs);
        PrettyTime prettyTime = new PrettyTime();
        System.out.println(prettyTime.format(date));

    }

}
