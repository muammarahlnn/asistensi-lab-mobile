package com.example.sqlitedatabase;

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

public class FormActivity extends AppCompatActivity {
    public static final String EXTRA_NOTE = "extra_note";
    public static final int RESULT_ADD = 101;
    public static final int RESULT_UPDATE = 201;
    public static final int RESULT_DELETE = 301;
    private NoteHelper noteHelper;
    private Note note;
    private EditText etTitle, etDesc;
    private boolean isEdit = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        etTitle = findViewById(R.id.et_title);
        etDesc = findViewById(R.id.et_desc);

        Button btnSave = findViewById(R.id.btn_save);
        Button btnDelete = findViewById(R.id.btn_delete);
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
                etDesc.setText(note.getDesc());
            }
            btnDelete.setVisibility(View.VISIBLE);
        } else {
            actionBarTitle = "Add";
            buttonTitle = "Save";
        }
        btnSave.setText(buttonTitle);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(actionBarTitle);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        btnSave.setOnClickListener(view -> save());
        btnDelete.setOnClickListener(view -> delete());
    }
    private void save() {
        String title = etTitle.getText().toString().trim();
        String desc = etDesc.getText().toString().trim();
        // Get the current date and time
        Date currentDate = new Date();

        // Define the date format you want to use
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
        String datePosted = dateFormat.format(currentDate);

        if (title.isEmpty()) {
            etTitle.setError("Please fill this field");
            return;
        }
        if (desc.isEmpty()) {
            etDesc.setError("Please fill this field");
            return;
        }
        note.setTitle(title);
        note.setDesc(desc);
        note.setDatePosted(datePosted);
        Intent intent = new Intent();
        intent.putExtra(EXTRA_NOTE, note);
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.NoteColumn.TITLE, title);
        values.put(DatabaseContract.NoteColumn.DESC, desc);
        if (isEdit) {
            datePosted = "Edited at " + dateFormat.format(currentDate);
            values.put(DatabaseContract.NoteColumn.DATE_POSTED, datePosted);
            long result = noteHelper.update(String.valueOf(note.getId()), values);
            if (result > 0) {
                note.setDatePosted(datePosted);
                setResult(RESULT_UPDATE, intent);
                finish();
            } else {
                Toast.makeText(this, "Failed to update data", Toast.LENGTH_SHORT).show();
            }
        } else {
            datePosted = "Added at " + dateFormat.format(currentDate);
            values.put(DatabaseContract.NoteColumn.DATE_POSTED, datePosted);
            long result = noteHelper.insert(values);
            if (result > 0) {
                note.setId((int) result);
                note.setDatePosted(datePosted);
                setResult(RESULT_ADD, intent);
                finish();
            } else {
                Toast.makeText(this, "Failed to add data", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void delete() {
        long result = noteHelper.deleteById(String.valueOf(note.getId()));
        if (result > 0) {
            Intent intent = new Intent();
            setResult(RESULT_DELETE, intent);
            finish();
        } else {
            Toast.makeText(this, "Failed to delete data", Toast.LENGTH_SHORT).show();
        }
    }
}