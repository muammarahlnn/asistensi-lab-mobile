package com.example.ldatatask;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ldatatask.adapter.NoteAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMain;
    private FloatingActionButton floatingActionButton;
    private NoteDatabase database;
    private NoteAdapter noteAdapter;
    private ProgressBar progressBar;
    private Handler handler;
    private boolean isSearching = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMain = findViewById(R.id.rvMain);
        floatingActionButton = findViewById(R.id.fabAddNote);
        progressBar = findViewById(R.id.progressBar);

        database = new NoteDatabase(this);

        rvMain.setLayoutManager(new LinearLayoutManager(this));
        noteAdapter = new NoteAdapter(this, database.getAllNote());
        rvMain.setAdapter(noteAdapter);

        floatingActionButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, AddEditNote.class)));

        noteAdapter.setOnClickListenerNote(id -> {
            Intent editNote = new Intent(MainActivity.this, AddEditNote.class);
            editNote.putExtra(NoteDatabase.id_note, id);
            startActivity(editNote);
        });

        handler = new Handler();
        Runnable runnable = () -> {
            hideProgressBar();
            showContent();
        };

        // Menyembunyikan konten saat aplikasi pertama kali dibuka
        hideContent();

        // Menjalankan handler untuk menyembunyikan ProgressBar dan menampilkan konten setelah jangka waktu tertentu
        handler.postDelayed(runnable, 2000); // Menyembunyikan ProgressBar dan menampilkan konten setelah 2000 milidetik (2 detik)
    }

    @Override
    protected void onResume() {
        super.onResume();
        noteAdapter.swapCursor(database.getAllNote());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.item_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!isSearching) {
                    isSearching = true;
                    showProgressBar();
                }

                handler.removeCallbacksAndMessages(null);

                // Menghilangkan ProgressBar jika teks pencarian kosong
                if (TextUtils.isEmpty(newText)) {
                    hideProgressBar();
                    showContent();
                    isSearching = false;
                    noteAdapter.swapCursor(database.getAllNote());
                    return true;
                }

                handler.postDelayed(() -> {
                    noteAdapter.swapCursor(database.searchNotes(newText));
                    hideProgressBar();
                    showContent();
                    isSearching = false;
                }, 500);

                return true;
            }
        });

        return true;
    }
    private void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    private void hideContent() {
        rvMain.setVisibility(View.INVISIBLE);
        floatingActionButton.setVisibility(View.INVISIBLE);
    }

    private void showContent() {
        rvMain.setVisibility(View.VISIBLE);
        floatingActionButton.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
        database.close();
    }
}