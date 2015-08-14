package com.csab.daggermvpstarter.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.csab.daggermvpstarter.R;
import com.csab.daggermvpstarter.mvp.model.Note;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NoteRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Inject
    LayoutInflater inflater;

    private List<Note> notes = Collections.emptyList();

    @Inject
    public NoteRecyclerAdapter() {
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.note_list_item, parent);
        return new NoteRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder vh, int position) {
        ViewHolder holder = (ViewHolder) vh;
        renderNote(notes.get(position), holder);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void updateItems(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    public void renderNote(Note note, ViewHolder holder) {
        holder.contentsView.setText(note.getContents());
        holder.createdView.setText(note.getCreatedDate().toString());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.contentsView)
        TextView contentsView;
        @Bind(R.id.createdView)
        TextView createdView;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
