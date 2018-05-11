package com.example.varun.notes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ArrayList<Note> notes = new ArrayList<Note>();

        Note note1 = new Note("Day 222", "another day...");
        notes.add(note1);

        Note note2 = new Note("Day 111", "boring.....");
        notes.add(note2);

        ListView listView = (ListView) findViewById(R.id.notes_list);

        NotesListAdapter adapter = new NotesListAdapter(this, R.layout.note_item_list_row, notes);

        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
