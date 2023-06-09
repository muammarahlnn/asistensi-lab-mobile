package com.example.t1n2_praktikummobile;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] bangunRuang = {"Bola", "Kerucut", "Balok"};

    int selectedItem = 0;

    private EditText editText;
    private EditText editText2;
    private EditText editText3;
    private Button button;
    private TextView tvResult;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, bangunRuang);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);

        button = findViewById(R.id.button);

        tvResult = findViewById(R.id.tv_result);

        button.setOnClickListener(view -> {
            if (selectedItem == 0) {
                calculateBola();
            } else if (selectedItem == 1) {
                calculateKerucut();
            } else {
                calculateBalok();
            }


        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //Untuk Menambahkan Toast
        Toast.makeText(getApplicationContext(), bangunRuang[i], Toast.LENGTH_SHORT).show();

        selectedItem = spinner.getSelectedItemPosition();

        if (selectedItem == 0) {
            showBolaInputs();
        } else if (selectedItem == 1) {
            showKerucutInputs();
        } else {
            showBalokInputs();
        }

        tvResult.setText("Hasil");
    }

    private void showBolaInputs() {
        showFirstInput(false);
        showSecondInput(false);
        editText3.setHint("Jari - jari");
        editText3.setText("");
    }

    private void showKerucutInputs() {
        showFirstInput(false);
        showSecondInput(true);
        editText2.setHint("Tinggi");
        editText3.setHint("Jari - jari");
        editText2.setText("");
        editText3.setText("");
    }

    private void showBalokInputs() {
        showFirstInput(true);
        showSecondInput(true);
        editText.setHint("Lebar");
        editText2.setHint("Tinggi");
        editText3.setHint("Panjang");
        editText.setText("");
        editText2.setText("");
        editText3.setText("");
    }

    private void showFirstInput(boolean isShow) {
        if (isShow) {
            editText.setVisibility(View.VISIBLE);
        } else {
            editText.setVisibility(View.GONE);
        }
    }

    private void showSecondInput(boolean isShow) {
        if (isShow) {
            editText2.setVisibility(View.VISIBLE);
        } else {
            editText2.setVisibility(View.GONE);
        }
    }

    private void calculateBola() {
        String nilai = editText3.getText().toString();

        if (nilai.isEmpty()) {
            editText3.setError("Data Tidak Boleh Kosong!");
            editText.requestFocus();
        } else {
            Double jarijari = Double.parseDouble(nilai);
            Double luas = 3.14 * (jarijari * 2);
            tvResult.setText(String.format("%.2f", luas));
        }
    }

    private void calculateKerucut() {
        String nilai1 = editText2.getText().toString();
        String nilai2 = editText3.getText().toString();

        if (nilai1.isEmpty()) {
            editText.setError("Data tidak boleh kosong!");
            editText.requestFocus();
        } else if (nilai2.isEmpty()) {
            editText2.setError("Data tidak boleh kosong!");
            editText2.requestFocus();
        } else {
            Integer Jarijari = Integer.parseInt(nilai1);
            Integer Tinggi = Integer.parseInt(nilai2);

            Integer Luas = Jarijari * Tinggi;
            tvResult.setText(String.valueOf(Luas));
        }
    }

    private void calculateBalok() {
        String Nilai1 = editText.getText().toString();
        String Nilai2 = editText2.getText().toString();
        String Nilai3 = editText3.getText().toString();

        if (Nilai1.isEmpty()) {
            editText.setError("Data tidak boleh kosong!");
            editText.requestFocus();
        } else if (Nilai2.isEmpty()) {
            editText2.setError("Data tidak boleh kosong!");
            editText2.requestFocus();
        } else if (Nilai3.isEmpty()) {
            editText3.setError("Data tidak boleh kosong!");
            editText3.requestFocus();
        } else {
            Integer Panjang = Integer.parseInt(Nilai1);
            Integer Lebar = Integer.parseInt(Nilai2);
            Integer Tinggi = Integer.parseInt(Nilai3);
            Integer Luas = Panjang * Lebar * Tinggi;
            tvResult.setText(String.valueOf(Luas));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}