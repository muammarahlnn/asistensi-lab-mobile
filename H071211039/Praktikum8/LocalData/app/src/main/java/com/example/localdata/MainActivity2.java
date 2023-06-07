package com.example.localdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

public class MainActivity2 extends AppCompatActivity {
    public static final String EXTRA_NOTE = "extra_note";
    public static final int RESULT_ADD = 101;
    public static final int RESULT_UPDATE = 201;
    public static final int RESULT_DELETE = 301;
    private NoteHelper noteHelper;
    private Note note;
    private boolean isEdit = false;
    private EditText etTitle, etDescription;
    private Button btnSubmit, btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etTitle = findViewById(R.id.et_title);
        etDescription = findViewById(R.id.et_description);
        btnSubmit = findViewById(R.id.btn_submit);
        btnUpdate = findViewById(R.id.btn_update);
        btnDelete = findViewById(R.id.btn_delete);

        noteHelper = NoteHelper.getInstance(getApplicationContext());
        noteHelper.open();


        note = getIntent().getParcelableExtra(EXTRA_NOTE);

        if (note != null) {
            isEdit = true;
        } else {
            note = new Note();
        }
        String actionBarTitle;
        String buttonTitle;
        if (isEdit) {
            actionBarTitle = "Change";
            buttonTitle = "Update";
            if (note != null) {
                etTitle.setText(note.getTitle());
                etDescription.setText(note.getDescription());
            }
            btnDelete.setVisibility(View.VISIBLE);
        } else {
            actionBarTitle = "Add";
            buttonTitle = "Save";
        }
        btnSubmit.setText(buttonTitle);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(actionBarTitle);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        btnSubmit.setOnClickListener(view -> save());
        btnDelete.setOnClickListener(view -> delete());
    }

    private void save() {
        String title = etTitle.getText().toString().trim();
        String description = etDescription.getText().toString().trim();
        if (title.isEmpty()) {
            etTitle.setError("Title must be filled");
            return;
        } else if (description.isEmpty()) {
            etDescription.setError("Description must be filled");
            return;
        }
        note.setTitle(title);
        note.setDescription(description);

        long currentTimeMillis = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String currentTime = dateFormat.format(new Date(currentTimeMillis));


        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        intent.putExtra(EXTRA_NOTE, note);

        ContentValues values = new ContentValues();
        values.put(DatabaseContract.NoteColumns.TITLE, title);
        values.put(DatabaseContract.NoteColumns.DESCRIPTION, description);

        if (isEdit) {
            values.put(DatabaseContract.NoteColumns.DATE, "Edited at " + currentTime);
            long result = noteHelper.update(String.valueOf(note.getId()), values);
            if (result > 0) {
                setResult(RESULT_UPDATE, intent);
                finish();
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity2.this, "Failed to update data", Toast.LENGTH_SHORT).show();
            }
        } else {
            values.put(DatabaseContract.NoteColumns.DATE, "Created at " + currentTime);
            long result = noteHelper.insert(values);
            if (result > 0) {
                note.setId((int) result);
                setResult(RESULT_ADD, intent);
                finish();
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity2.this, "Failed to add data", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void delete() {
        long result = noteHelper.deleteById(String.valueOf(note.getId()));
        if (result > 0) {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            setResult(RESULT_DELETE, intent);
            finish();
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity2.this, "Failed to delete data", Toast.LENGTH_SHORT).show();
        }
    }

}