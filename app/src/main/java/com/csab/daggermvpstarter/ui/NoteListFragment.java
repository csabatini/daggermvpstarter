package com.csab.daggermvpstarter.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.csab.daggermvpstarter.R;
import com.csab.daggermvpstarter.di.component.DaggerNoteFragmentComponent;
import com.csab.daggermvpstarter.di.module.NoteFragmentModule;
import com.csab.daggermvpstarter.mvp.presenter.NoteListPresenterImpl;
import com.csab.daggermvpstarter.mvp.view.NoteListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoteListFragment extends BaseFragment implements NoteListView {

    @Inject
    NoteListPresenterImpl presenter;
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

    @OnClick(R.id.fab)
    void relayClickToPresenter() {
        presenter.buttonClick();
    }
}
