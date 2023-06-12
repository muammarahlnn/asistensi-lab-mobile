package com.example.sqlitedatabase;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private TextView tvAlert;
    private TextInputLayout tfSearch;
    private FloatingActionButton fabAdd;
    private Note note;
    private NoteAdapter adapter;
    private final ActivityResultLauncher<Intent> resultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getData() != null) {
                            switch (result.getResultCode()) {
                                case FormActivity.RESULT_ADD:
                                    note =
                                            result.getData().getParcelableExtra(FormActivity.EXTRA_NOTE);
                                    refreshRecyclerView();
                                    Toast.makeText(this, "Notes added successfully",
                                            Toast.LENGTH_SHORT).show();
                                    break;
                                case FormActivity.RESULT_UPDATE:
                                    note =
                                            result.getData().getParcelableExtra(FormActivity.EXTRA_NOTE);
                                    refreshRecyclerView();
                                    Toast.makeText(this, "Notes updated successfully",
                                            Toast.LENGTH_SHORT).show();
                                    break;
                                case FormActivity.RESULT_DELETE:
                                    note = null;
                                    refreshRecyclerView();
                                    Toast.makeText(this, "Notes deleted successfully",
                                            Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
                    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fabAdd = findViewById(R.id.fab_add);
        tvAlert = findViewById(R.id.tv_alert);
        tfSearch = findViewById(R.id.tf_search);

        fabAdd.setOnClickListener(view -> {
            Intent toForm = new Intent(MainActivity.this, FormActivity.class);
            resultLauncher.launch(toForm);
        });

        // get data from studenthelper
        NoteHelper noteHelper = NoteHelper.getInstance(this);
        noteHelper.open();
        Cursor cursor = noteHelper.queryAll();
        ArrayList<Note> dataList = MappingHelper.mapCursorToArrayList(cursor);
        noteHelper.close();

        // setup rv
        RecyclerView rvStudents = findViewById(R.id.rv_note);
        rvStudents.setHasFixedSize(true);
        rvStudents.setLayoutManager(new LinearLayoutManager(this));

        // set adapter to rv
        adapter = new NoteAdapter(dataList);
        adapter.setClickListener(new NoteAdapter.ClickListener() {
            @Override
            public void onItemClicked(Note note) {
                Intent intent = new Intent(MainActivity.this, FormActivity.class);
                intent.putExtra(FormActivity.EXTRA_NOTE, note);
                resultLauncher.launch(intent);
            }
        });
        rvStudents.setAdapter(adapter);
        updateTvAlertVisibility(dataList);

        tfSearch.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Call the searchNotes method with the new search keyword
                new LoadNotesAsync(MainActivity.this, new LoadNotesCallback() {
                    @Override
                    public void postExecute(ArrayList<Note> notes) {
                        adapter.setData(notes);
                        adapter.notifyDataSetChanged();
                    }
                }).search(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing
            }
        });
    }

    private static class LoadNotesAsync {
        private final WeakReference<Context> weakContext;
        private final WeakReference<LoadNotesCallback> weakCallback;
        private LoadNotesAsync(Context context, LoadNotesCallback callback) {
            weakContext = new WeakReference<>(context);
            weakCallback = new WeakReference<>(callback);
        }
        void execute() {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());
            executor.execute(() -> {
                Context context = weakContext.get();
                NoteHelper noteHelper = NoteHelper.getInstance(context);
                noteHelper.open();
                Cursor notesCursor = noteHelper.queryAll();
                ArrayList<Note> notes =
                        MappingHelper.mapCursorToArrayList(notesCursor);
                noteHelper.close();
                handler.post(() -> weakCallback.get().postExecute(notes));
            });
        }

        void search(String keyword) {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());
            executor.execute(() -> {
                Context context = weakContext.get();
                NoteHelper noteHelper = NoteHelper.getInstance(context);
                noteHelper.open();
                Cursor notesCursor = noteHelper.queryByTitle(keyword);
                ArrayList<Note> searchResults = MappingHelper.mapCursorToArrayList(notesCursor);
                noteHelper.close();
                handler.post(() -> weakCallback.get().postExecute(searchResults));
            });
        }
    }
    interface LoadNotesCallback {
        void postExecute(ArrayList<Note> notes);
    }

    private void updateTvAlertVisibility(ArrayList<Note> dataList) {
        if (dataList.isEmpty()) {
            tvAlert.setVisibility(View.VISIBLE);
            tfSearch.setVisibility(View.GONE);
        } else {
            tvAlert.setVisibility(View.GONE);
            tfSearch.setVisibility(View.VISIBLE);
        }
    }
    private void refreshRecyclerView() {
        new LoadNotesAsync(this, new LoadNotesCallback() {
            @Override
            public void postExecute(ArrayList<Note> notes) {
                adapter.setData(notes);
                adapter.notifyDataSetChanged();
                updateTvAlertVisibility(notes);
            }
        }).execute();
    }

}