package com.example.varun.notes;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.varun.notes.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = "HomeActivity";

    private DatabaseHelper db;
    private List<Note> notes;
    private SwipeRefreshLayout swipeRefreshLayout;
    private NotesListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        notes = new ArrayList<Note>();
        db = new DatabaseHelper(this);
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) this);

        // fetch notes onCreate
        fetchAllNotes();

        // Set Listview content
        ListView listView = (ListView) findViewById(R.id.notes_list);
        adapter = new NotesListAdapter(this, R.layout.note_item_list_row, notes);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }

    public void fetchAllNotes() {
        notes.clear();
        List<Note> data = db.getAllNotes();
        notes.addAll(data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,v,menuInfo);
        menu.add(0,v.getId(),0,"Delete");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;
        if(item.getTitle()=="Delete") {
            Note note = notes.get(index);
            notes.remove(index);
            adapter.notifyDataSetChanged();
            db.deleteNote(note);
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    // Navigate to Add Note Activity
    public void addNote(MenuItem item) {
        Intent i = new Intent(this, NewNoteActivity.class);
        startActivity(i);
    }

    // Pull down to refresh
    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        fetchAllNotes();
        adapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }
}
