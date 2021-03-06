package com.csab.daggermvpstarter.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.csab.daggermvpstarter.R;
import com.csab.daggermvpstarter.adapter.NoteRecyclerAdapter;
import com.csab.daggermvpstarter.adapter.SimpleDividerItemDecoration;
import com.csab.daggermvpstarter.adapter.SimpleItemTouchHelperCallback;
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

public class NoteListFragment extends BaseFragment
        implements NoteListView {

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
        View view = inflater.inflate(R.layout.frament_note_list, container, false);
        ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(activity));

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.pause();
    }

    @Override
    public void showNotes(List<Note> notes) {
        adapter.updateItems(notes);
    }

    @Override
    public void removeNoteFromList(int position) {
        adapter.removeItem(position);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSnack(String message) {
        Snackbar.make(fab, message, Snackbar.LENGTH_SHORT).show();
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
                .appComponent(appComponent)
                .activityModule(activityModule)
                .noteListModule(new NoteListModule(this))
                .build()
                .inject(this);
    }
}
