package com.example.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    EditText panjangBalok, lebarBalok, tinggiBalok, tinggiKerucut, jariKerucut, jariBola ;
    Button hitung;
    TextView hasil;
    Spinner spinner;
    String pilih;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        viewFlipper = findViewById(R.id.viewFlipper);
        panjangBalok = findViewById(R.id.panjang_balok);
        lebarBalok = findViewById(R.id.lebar_balok);
        tinggiBalok = findViewById(R.id.tinggi_balok);
        tinggiKerucut = findViewById(R.id.tinggi_kerucut);
        jariKerucut = findViewById(R.id.jari_kerucut);
        jariBola = findViewById(R.id.jari_bola);
        hitung = findViewById(R.id.hitung);
        hasil = findViewById(R.id.hasil);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pilih = spinner.getSelectedItem().toString();
//
//                if (pilih.equals("Balok")){
//                    viewFlipper.setDisplayedChild(0);
//                }else if (pilih.equals("Kerucut")){
//                    viewFlipper.setDisplayedChild(1);
//                }else if (pilih.equals("Bola")) {
//                    viewFlipper.setDisplayedChild(2);
//                }else {
//                viewFlipper.setDisplayedChild(0);
//                }
                viewFlipper.setDisplayedChild(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pilih.equals("Balok")) {
                    try {
                        boolean isEmpty = false;
                        if(panjangBalok.getText().toString().isEmpty()){
                            panjangBalok.setError("field ini tidak boleh kosong!");
                            Toast.makeText(MainActivity.this, "Masukkan Panjang Balok!", Toast.LENGTH_SHORT).show();
                            isEmpty = true;
                        }
                        if (lebarBalok.getText().toString().isEmpty()) {
                            lebarBalok.setError("field ini tidak boleh kosong!");
                            Toast.makeText(MainActivity.this, "Masukkan Lebar Balok!", Toast.LENGTH_SHORT).show();
                            isEmpty = true;
                        }
                        if (tinggiBalok.getText().toString().isEmpty()) {
                            tinggiBalok.setError("field ini tidak boleh kosong!");
                            Toast.makeText(MainActivity.this, "Masukkan Tinggi Balok!", Toast.LENGTH_SHORT).show();
                            isEmpty = true;
                        }
                        if (!isEmpty) {
                            Long Panjang = Long.valueOf(panjangBalok.getText().toString());
                            Long Lebar = Long.valueOf(lebarBalok.getText().toString());
                            Long Tinggi = Long.valueOf(tinggiBalok.getText().toString());

                            Long Hasil = Panjang * Lebar * Tinggi;
                            hasil.setText(String.valueOf(Hasil));
                        }
                    }catch (NumberFormatException ex) {
                            Toast.makeText(MainActivity.this, "inputan terlalu besar", Toast.LENGTH_SHORT).show();
                        }

                }else if (pilih.equals("Kerucut")) {
                    try {
                        boolean isEmpty = false;
                        if (tinggiKerucut.getText().toString().isEmpty()) {
                            tinggiKerucut.setError("field ini tidak boleh kosong!");
                            Toast.makeText(MainActivity.this, "Masukkan Tinggi Kerucut!", Toast.LENGTH_SHORT).show();
                            isEmpty = true;
                        }
                        if (jariKerucut.getText().toString().isEmpty()) {
                            jariKerucut.setError("field ini tidak boleh kosong!");
                            Toast.makeText(MainActivity.this, "Masukkan jari-jari Kerucut!", Toast.LENGTH_SHORT).show();
                            isEmpty = true;
                        }
                        if (!isEmpty) {
                            Long Tinggi = Long.valueOf(tinggiKerucut.getText().toString());
                            Long jari = Long.valueOf(jariKerucut.getText().toString());

                            double Hasil = 1.0 / 3.0 * jari * jari * Tinggi * 3.14;
                            hasil.setText(String.format("%.2f", Hasil));
                        }
                    } catch (NumberFormatException ex) {
                        Toast.makeText(MainActivity.this, "inputan terlalu besar", Toast.LENGTH_SHORT).show();
                    }

                }else if (pilih.equals("Bola")) {
                    try {
                        if (jariBola.getText().toString().isEmpty()) {
                            jariBola.setError("field ini tidak boleh kosong!");
                            Toast.makeText(MainActivity.this, "Masukkan jari-jari Bola!", Toast.LENGTH_SHORT).show();
                        } else {
                            Long jari = Long.valueOf(jariBola.getText().toString());

                            double Hasil = 4.0 / 3.0 * jari * jari * jari * 3.14;
                            hasil.setText(String.format("%.2f", Hasil));
                        }
                    } catch (NumberFormatException ex) {
                            Toast.makeText(MainActivity.this, "inputan terlalu besar", Toast.LENGTH_SHORT).show();
                    }



                }
            }
        });
    }
}