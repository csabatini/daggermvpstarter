package com.csab.daggermvpstarter.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.csab.daggermvpstarter.R;
import com.csab.daggermvpstarter.Utils;
import com.csab.daggermvpstarter.mvp.model.Note;
import com.csab.daggermvpstarter.mvp.presenter.NoteListPresenter;

import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NoteRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements ItemTouchHelperAdapter {

    private NoteListPresenter presenter;
    private Activity activity;

    private List<Note> notes = Collections.emptyList();

    public NoteRecyclerAdapter(Activity activity, NoteListPresenter presenter) {
        this.activity = activity;
        this.presenter = presenter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.note_list_item, parent, false);
        return new NoteRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder vh, final int position) {
        ViewHolder holder = (ViewHolder) vh;
        renderNote(notes.get(position), holder);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    @Override
    public void onItemSwiped(int position, String direction) {
        presenter.noteSwipe(position, direction);
    }

    public void updateItems(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        notes.remove(position);
        notifyItemRemoved(position);
    }

    public void renderNote(Note note, ViewHolder holder) {
        holder.contentsView.setText(note.getContents());
        holder.createdView.setText(Utils.formatSerializedDate(activity, note.getCreatedDate()));
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
