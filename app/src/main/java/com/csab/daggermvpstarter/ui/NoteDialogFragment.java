package com.csab.daggermvpstarter.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.csab.daggermvpstarter.R;
import com.csab.daggermvpstarter.di.component.AppComponent;
import com.csab.daggermvpstarter.di.component.DaggerNoteDialogComponent;
import com.csab.daggermvpstarter.di.module.ActivityModule;
import com.csab.daggermvpstarter.di.module.NoteDialogModule;
import com.csab.daggermvpstarter.mvp.presenter.NoteDialogPresenter;
import com.csab.daggermvpstarter.mvp.view.NoteDialogView;

import javax.inject.Inject;

public class NoteDialogFragment extends BaseDialogFragment implements NoteDialogView {

    @Inject
    NoteDialogPresenter presenter;
    @Inject
    Activity activity;
    @Inject
    LayoutInflater layoutInflater;

    private AlertDialog alertDialog;
    private EditText editText;

    public static NoteDialogFragment newInstance() {
        return new NoteDialogFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.create();
    }

    @Override
    public void createDialog() {
        View view = layoutInflater.inflate(R.layout.dialog_add_note, null);
        alertDialog = new AlertDialog.Builder(activity)
                .setTitle(R.string.app_name)
                .setView(view)
                .setPositiveButton(R.string.btn_pos, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        presenter.saveClick();
                    }
                })
                .setNegativeButton(R.string.btn_neg, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        presenter.cancelClick();
                    }
                })
                .create();
        editText = (EditText) view.findViewById(R.id.noteText);
    }

    @Override
    public void dismissDialog() {
        alertDialog.dismiss();
    }

    @Override
    public String captureInputText() {
        return editText.getText().toString();
    }

    @Override
    protected void setupGraph(AppComponent appComponent, ActivityModule activityModule) {
        DaggerNoteDialogComponent.builder()
                .appComponent(appComponent)
                .activityModule(activityModule)
                .noteDialogModule(new NoteDialogModule(this))
                .build()
                .inject(this);
    }
}
