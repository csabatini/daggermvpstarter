package com.csab.daggermvpstarter.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.csab.daggermvpstarter.R;
import com.csab.daggermvpstarter.adapter.NoteRecyclerAdapter;
import com.csab.daggermvpstarter.di.component.AppComponent;
import com.csab.daggermvpstarter.di.component.DaggerNoteListComponent;
import com.csab.daggermvpstarter.di.module.ActivityModule;
import com.csab.daggermvpstarter.di.module.NoteListModule;
import com.csab.daggermvpstarter.mvp.model.Note;
import com.csab.daggermvpstarter.mvp.presenter.NoteListPresenter;
import com.csab.daggermvpstarter.mvp.view.NoteListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoteListFragment extends BaseFragment implements NoteListView {

    @Inject
    NoteListPresenter presenter;
    @Inject
    Activity activity;
    @Inject
    NoteRecyclerAdapter adapter;

    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.recycler)
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frament_note_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.resume();
    }

    @Override
    public void showNotes(List<Note> notes) {
        adapter.updateItems(notes);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDialog() {
        NoteDialogFragment dialog = NoteDialogFragment.newInstance();
        dialog.show(getFragmentManager(), null);
    }

    @OnClick(R.id.fab)
    void relayClickToPresenter() {
        presenter.buttonClick();
    }

    @Override
    protected void setupGraph(AppComponent appComponent, ActivityModule activityModule) {
        DaggerNoteListComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(getActivityModule())
                .noteListModule(new NoteListModule(this))
                .build()
                .inject(this);
    }
}
