package com.example.varun.notes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by varun on 10-05-2018.
 */

public class NotesListAdapter extends ArrayAdapter<Note> {

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private ArrayList<Note> mNotes;
    private int mViewResourceId;

    public NotesListAdapter(Context context, int viewResourceId, ArrayList<Note> notes) {
        super(context,viewResourceId);

        mContext = context;
        mNotes = notes;
        mViewResourceId = viewResourceId;
    }

    @Override
    public int getCount() {
        return mNotes.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = mLayoutInflater.from(mContext).inflate(R.layout.note_item_list_row,parent,false);

        TextView title = (TextView) convertView.findViewById(R.id.note_title);
        title.setText(mNotes.get(position).mTitle);

        return convertView;
    }
}
