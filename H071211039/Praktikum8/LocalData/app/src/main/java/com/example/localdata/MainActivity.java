package com.example.localdata;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputLayout;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private EditText search;
    private TextInputLayout lysearch;
    private ProgressBar progressBar;
    NoteAdapter adapterNotes;
    private TextView tv_first;
    private ImageView iv_add;
    private NoteHelper notesHelper;
    Executor executor;
    Handler handler;

    private final ActivityResultLauncher<Intent> resultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getData() != null) {
                            switch (result.getResultCode()) {
                                case MainActivity2.RESULT_ADD:
                                    Note resultNote = result.getData().getParcelableExtra(MainActivity2.EXTRA_NOTE);
                                    adapterNotes.addNote(resultNote);
                                    showCurrentUser();
                                    Toast.makeText(this, "Student added successfully",
                                            Toast.LENGTH_SHORT).show();
                                    break;
                                case MainActivity2.RESULT_UPDATE:
                                    Note updatedNote = result.getData().getParcelableExtra( MainActivity2.EXTRA_NOTE);
                                    adapterNotes.addNote(updatedNote);
                                    showCurrentUser();
                                    Toast.makeText(this, "Student updated successfully",
                                            Toast.LENGTH_SHORT).show();
                                    break;
                                case MainActivity2.RESULT_DELETE:
                                    Note deletedNote = null;
                                    adapterNotes.addNote(deletedNote);
                                    showCurrentUser();
                                    Toast.makeText(this, "Student deleted successfully",
                                            Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
                    });

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv_note);
        tv_first = findViewById(R.id.tv_note);
        iv_add = findViewById(R.id.iv_add);
        progressBar = findViewById(R.id.progressbar);
        search = findViewById(R.id.et_search);
        lysearch = findViewById(R.id.lysearch);
        adapterNotes = new NoteAdapter();

        notesHelper = NoteHelper.getInstance(this);
        notesHelper.open();

        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                resultLauncher.launch(intent);
            }
        });


        new LoadStudentsAsync(this, notess -> {
            if (notess.size() > 0) {
                adapterNotes.setData(notess);
                rv.setAdapter(adapterNotes);
            }
            showCurrentUser();
        }).execute();

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                searching(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

//        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                searchData(newText);
//                return true;
//         }
//        });
    }

    private void searching(String searchText) {

        if (!searchText.isEmpty()) {
            progressBar.setVisibility(View.VISIBLE);

            Executor currentExecutor = Executors.newSingleThreadExecutor();
            Handler currentHandler = new Handler(Looper.getMainLooper());
            currentExecutor.execute(() -> {
                ArrayList<Note> searchResults = notesHelper.searchNotes(searchText);

                currentHandler.post(() -> {
                    adapterNotes.setData(searchResults);
                    progressBar.setVisibility(View.GONE);
                });
            });
        } else {
            // Jika teks pencarian kosong, tampilkan semua data
            Executor currentExecutor = Executors.newSingleThreadExecutor();
            Handler currentHandler = new Handler(Looper.getMainLooper());
            currentExecutor.execute(() -> {
                ArrayList<Note> searchResults = notesHelper.searchNotes("");

                currentHandler.post(() -> {
                    adapterNotes.setData(searchResults);
                    progressBar.setVisibility(View.GONE);
                });
            });
            showCurrentUser();
        }
    }

    private void showCurrentUser() {
        if (adapterNotes.getNotes().size() > 0) {
            tv_first.setVisibility(View.GONE);
            search.setVisibility(View.VISIBLE);

        } else {
            lysearch.setVisibility(View.GONE);
            tv_first.setVisibility(View.VISIBLE);
        }
    }

    private static class LoadStudentsAsync {
        private final WeakReference<Context> weakContext;
        private final WeakReference<LoadStudentsCallback> weakCallback;
        private LoadStudentsAsync(Context context, LoadStudentsCallback callback) {
            weakContext = new WeakReference<>(context);
            weakCallback = new WeakReference<>(callback);
        }
        void execute() {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());
            executor.execute(() -> {
                Context context = weakContext.get();
                NoteHelper notesHelper = NoteHelper.getInstance(context);
                notesHelper.open();

                Cursor notesCursor = notesHelper.queryAll();
                ArrayList<Note> notes = MappingHelper.mapCursorToArrayList(notesCursor);

                notesHelper.close();
                handler.post(() -> weakCallback.get().postExecute(notes));
            });
        }
    }
    interface LoadStudentsCallback {
        void postExecute(ArrayList<Note> notess);
    }
}