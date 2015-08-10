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
import com.csab.daggermvpstarter.di.component.DaggerNoteComponent;
import com.csab.daggermvpstarter.di.module.NoteModule;
import com.csab.daggermvpstarter.mvp.presenter.NoteListPresenterImpl;
import com.csab.daggermvpstarter.mvp.view.NoteListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoteListFragment extends BaseFragment implements NoteListView {

    @Inject
    Activity activity;
    @Inject
    NoteListPresenterImpl presenter;

    @Bind(R.id.fab)
    FloatingActionButton mFab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frament_note_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DaggerNoteComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(getActivityModule())
                .noteModule(new NoteModule(this))
                .build()
                .inject(this);
        ButterKnife.bind(activity);
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
