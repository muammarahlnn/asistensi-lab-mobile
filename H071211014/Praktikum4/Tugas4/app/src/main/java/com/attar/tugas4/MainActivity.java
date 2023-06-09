package com.attar.tugas4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.attar.tugas4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvContact.setLayoutManager(new LinearLayoutManager(this));
        ContactAdapter adapter = new ContactAdapter(DataSource.contacts());
        adapter.setClickListener(contact -> {
            Toast.makeText(this, contact.getContact(), Toast.LENGTH_SHORT).show();
        });
        binding.rvContact.setAdapter(adapter);
    }
}