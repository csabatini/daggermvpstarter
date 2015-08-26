package com.csab.daggermvpstarter.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.afollestad.materialdialogs.MaterialDialog;
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
    LayoutInflater inflater;

    private MaterialDialog alertDialog;
    private EditText editText;

    public static NoteDialogFragment newInstance() {
        return new NoteDialogFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.create();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return alertDialog;
    }

    @Override
    public void createDialog() {
        View view = inflater.inflate(R.layout.dialog_add_note, null);
        alertDialog = new MaterialDialog.Builder(activity)
                .title(R.string.add_note)
                .customView(view, false)
                .positiveText(R.string.btn_pos)
                .negativeText(R.string.btn_neg)
                .callback(new MaterialDialog.ButtonCallback() {
                    @Override
                    public void onPositive(MaterialDialog dialog) {
                        super.onPositive(dialog);
                        presenter.saveClick();
                    }

                    @Override
                    public void onNegative(MaterialDialog dialog) {
                        super.onNegative(dialog);
                        presenter.cancelClick();
                    }
                })
                .build();
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
