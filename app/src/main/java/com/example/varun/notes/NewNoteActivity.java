package com.example.varun.notes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.varun.notes.database.DatabaseHelper;

public class NewNoteActivity extends AppCompatActivity {

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateFields()) {
                    saveNote();
                    finish();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.new_note_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean validateFields() {
        EditText title = (EditText) findViewById(R.id.note_title_text);
        String strTitle = title.getText().toString();
        if(TextUtils.isEmpty(strTitle)) {
            title.setError("Title should not be empty");
            return false;
        }
        return true;
    }

    public void saveNote() {
        EditText title = (EditText) findViewById(R.id.note_title_text);
        EditText content = (EditText) findViewById(R.id.note_content_text);

        Note note = new Note(title.getText().toString(), content.getText().toString());

        db = new DatabaseHelper(this);

        long id = db.insertNote(note);

        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }
}
