package com.attar.tugaspraktikum1no2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.attar.tugaspraktikum1no2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private Geometries selectedGeometry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                setSelectedGeometry();
                arrangeInputs();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void setSelectedGeometry() {
        int ordinal = binding.spinner.getSelectedItemPosition();
        switch(ordinal) {
            case 0 :
                selectedGeometry = Geometries.BOLA;
                break;
            case 1 :
                selectedGeometry = Geometries.KERUCUT;
                break;
            case 2 :
                selectedGeometry = Geometries.BALOK;
                break;
        }
    }
    private void arrangeInputs() {
        switch (selectedGeometry) {
            case BOLA :
                binding.tvInputan2.setVisibility(View.GONE);
                binding.tvInputan3.setVisibility(View.GONE);
                binding.etInputan2.setVisibility(View.GONE);
                binding.etInputan3.setVisibility(View.GONE);
                binding.tvInputan1.setText("Jari-jari");
                break;
            case KERUCUT :
                binding.tvInputan2.setVisibility(View.VISIBLE);
                binding.etInputan2.setVisibility(View.VISIBLE);

                binding.tvInputan3.setVisibility(View.GONE);
                binding.etInputan3.setVisibility(View.GONE);
                break;
            case BALOK:
                binding.tvInputan2.setVisibility(View.VISIBLE);
                binding.tvInputan3.setVisibility(View.VISIBLE);
                binding.etInputan2.setVisibility(View.VISIBLE);
                binding.etInputan3.setVisibility(View.VISIBLE);
                break;
        }
    }
}