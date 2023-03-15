package com.example.praktikum1_2;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import com.example.praktikum1_2.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    private ActivityMainBinding binding;

    private final String bola = "Bola";
    private final String kerucut = "Kerucut";
    private final String balok = "Balok";

    private String selectedPick = bola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.picker.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedPick = binding.picker.getSelectedItem().toString();
                arrangeInputs();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        binding.btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult();
            }
        });
    }

    private void arrangeInputs() {
        switch (selectedPick) {
            case bola:
                showBolaInput();
                break;
            case kerucut:
                showKerucutInput();
                break;
            case balok:
                showBalokInput();
                break;
        }
    }

    private void showBolaInput() {
        binding.tvPanjang.setText("Jari - Jari");
        binding.tvLebar.setVisibility(View.GONE);
        binding.etLebar.setVisibility(View.GONE);
        binding.tvTinggi.setVisibility(View.GONE);
        binding.etTinggi.setVisibility(View.GONE);
    }

    private void showKerucutInput() {
        binding.tvPanjang.setText("Jari - Jari");
        binding.tvLebar.setVisibility(View.GONE);
        binding.etLebar.setVisibility(View.GONE);
        binding.tvTinggi.setVisibility(View.VISIBLE);
        binding.etTinggi.setVisibility(View.VISIBLE);
    }
    private void showBalokInput() {
        binding.tvPanjang.setText("Panjang");
        binding.tvLebar.setVisibility(View.VISIBLE);
        binding.etLebar.setVisibility(View.VISIBLE);
        binding.tvTinggi.setVisibility(View.VISIBLE);
        binding.etTinggi.setVisibility(View.VISIBLE);
    }

    private void calculateResult() {
        switch (selectedPick) {
            case bola:
                calculateBola();
                break;
            case kerucut:
                calculateKerucut();
                break;
            case balok:
                calculateBalok();
                break;
        }
    }

    private void calculateBola() {
        String nilai1 = binding.etPanjang.getText().toString();
        if(nilai1.isEmpty()) {
            binding.etPanjang.setError("Data tidak boleh kosong");
            binding.etPanjang.requestFocus();
        }else {
            Double panjang = Double.parseDouble(nilai1);
            Double vol = (1.33 * 3.14 * (panjang * panjang * panjang));
            binding.hasil.setText(String.format("%.2f", vol));
        }
    }

    private void calculateKerucut() {
        String nilai1 = binding.etPanjang.getText().toString();
        String nilai2 = binding.etTinggi.getText().toString();
        if(nilai1.isEmpty()) {
            binding.etPanjang.setError("Data tidak boleh kosong");
            binding.etPanjang.requestFocus();
        }else if(nilai2.isEmpty()) {
            binding.etTinggi.setError("Data tidak boleh kosong");
            binding.etTinggi.requestFocus();
        }else {
            Double panjang = Double.parseDouble(nilai1);
            Double tinggi = Double.parseDouble(nilai2);
            Double vol = 0.33 * 3.14 * (panjang * panjang) * tinggi;
            binding.hasil.setText(String.format("%.2f", vol));
        }
    }

    private void calculateBalok() {
        String nilai1 = binding.etPanjang.getText().toString();
        String nilai2 = binding.etLebar.getText().toString();
        String nilai3 = binding.etTinggi.getText().toString();
        if(nilai1.isEmpty()) {
            binding.etPanjang.setError("Data tidak boleh kosong");
            binding.etPanjang.requestFocus();
        }else if(nilai2.isEmpty()) {
            binding.etLebar.setError("Data tidak boleh kosong");
            binding.etLebar.requestFocus();
        }else if(nilai3.isEmpty()) {
            binding.etTinggi.setError("Data tidak boleh kosong");
            binding.etTinggi.requestFocus();
        }else {
            Double panjang = Double.parseDouble(nilai1);
            Double lebar = Double.parseDouble(nilai2);
            Double tinggi = Double.parseDouble(nilai3);
            Double vol = panjang * lebar * tinggi;
            binding.hasil.setText(String.format("%.2f", vol));
        }
    }
}