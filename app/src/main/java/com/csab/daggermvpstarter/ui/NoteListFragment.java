package com.csab.daggermvpstarter.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.support.v7.app.AlertDialog;

import com.csab.daggermvpstarter.R;
import com.csab.daggermvpstarter.di.component.DaggerNoteFragmentComponent;
import com.csab.daggermvpstarter.di.module.NoteFragmentModule;
import com.csab.daggermvpstarter.mvp.presenter.NoteListPresenter;
import com.csab.daggermvpstarter.mvp.view.NoteListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoteListFragment extends BaseFragment
        implements NoteListView, DialogInterface.OnClickListener {

    @Inject
    NoteListPresenter presenter;
    @Inject
    Activity activity;

    @Bind(R.id.fab)
    FloatingActionButton mFab;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DaggerNoteFragmentComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(getActivityModule())
                .noteFragmentModule(new NoteFragmentModule(this))
                .build()
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frament_note_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void showNotes(List<String> notes) {
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDialog() {
        // TODO: move to within DialogFragment
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Test")
                .setView(R.layout.dialog_add_note)
                .setPositiveButton(R.string.btn_pos, NoteListFragment.this)
                .setNegativeButton(R.string.btn_neg, NoteListFragment.this)
                .create()
                .show();
    }

    @OnClick(R.id.fab)
    void relayClickToPresenter() {
        presenter.buttonClick();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

    }
}
