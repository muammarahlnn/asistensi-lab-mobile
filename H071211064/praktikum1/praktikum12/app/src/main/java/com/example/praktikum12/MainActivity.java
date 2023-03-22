package com.example.praktikum12;

import android.content.Intent;
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


public class MainActivity extends AppCompatActivity {

    Button submit;
    EditText editPanjang, editLebar, editTinggi, editJari;
    TextView finalResult, tvHeight, tvWidth, tvLength, tvRadius;

    Spinner spinner;

    int selectedGeometryId = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Menampilkan Layout Tabung
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mendapatkan nilai dari inputan
        editPanjang = findViewById(R.id.editPanjang);
        editLebar = findViewById(R.id.editLebar);
        editTinggi = findViewById(R.id.editTinggi);
        editJari = findViewById(R.id.jariJari);
        submit = findViewById(R.id.submit);
        finalResult = findViewById(R.id.tvResult);
        tvHeight = findViewById(R.id.textViewHeight);
        tvWidth = findViewById(R.id.textViewWidth);
        tvLength = findViewById(R.id.textViewLength);
        tvRadius = findViewById(R.id.textView);


        //------------------------Spinner Untuk Mengganti Activity------------------------
        spinner = findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedGeometryId = spinner.getSelectedItemPosition();
                switch (selectedGeometryId) {
                    case 2:
                        finalResult.setText("");
                        tvHeight.setVisibility(View.GONE);
                        tvLength.setVisibility(View.GONE);
                        tvWidth.setVisibility(View.GONE);
                        tvRadius.setVisibility(View.VISIBLE);
                        editJari.setVisibility(View.VISIBLE);
                        editTinggi.setVisibility(View.GONE);
                        editLebar.setVisibility(View.GONE);
                        editPanjang.setVisibility(View.GONE);
                        break;
                    case 1:
                        finalResult.setText("");
                        tvHeight.setVisibility(View.VISIBLE);
                        tvLength.setVisibility(View.GONE);
                        tvWidth.setVisibility(View.GONE);
                        tvRadius.setVisibility(View.VISIBLE);
                        editJari.setVisibility(View.VISIBLE);
                        editTinggi.setVisibility(View.VISIBLE);
                        editLebar.setVisibility(View.GONE);
                        editPanjang.setVisibility(View.GONE);
                        break;
                    case 0:
                        tvHeight.setVisibility(View.VISIBLE);
                        tvLength.setVisibility(View.VISIBLE);
                        tvWidth.setVisibility(View.VISIBLE);
                        tvRadius.setVisibility(View.GONE);
                        editJari.setVisibility(View.GONE);
                        editTinggi.setVisibility(View.VISIBLE);
                        editLebar.setVisibility(View.VISIBLE);
                        editPanjang.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                boolean isEmpty = false;
                if (editPanjang.getText().toString().isEmpty()){
                    editPanjang.setError("Inputan tidak boleh kosong");
                    isEmpty = true;
                }

                if(editLebar.getText().toString().isEmpty()) {
                    editLebar.setError("Inputan tidak boleh kosong");
                    isEmpty = true;
                }
                if(editTinggi.getText().toString().isEmpty()){
                    editTinggi.setError("Inputan tidak boleh kosong");
                    isEmpty = true;
                }
                if(!isEmpty){
                 double jari, tinggi, panjang, lebar, volume, volume2, volume3;
                    switch (selectedGeometryId) {
                        case 2:
                             jari = Double.parseDouble(editJari.getText().toString());
                             volume = (4 * 3.14 * jari * jari * jari) / 3;
                            finalResult.setText(String.valueOf(volume));
                            break;
                        case 1:
                             tinggi = Double.parseDouble(editTinggi.getText().toString());
                             jari = Double.parseDouble(editJari.getText().toString());
                             volume2 = 3.14 * jari * jari * tinggi;
                            finalResult.setText(String.valueOf(volume2));
                            break;
                        case 0:
                             panjang = Double.parseDouble(editPanjang.getText().toString());
                             lebar = Double.parseDouble(editLebar.getText().toString());
                             tinggi = Double.parseDouble(editTinggi.getText().toString());
                            volume3 = panjang * lebar * tinggi;
                            finalResult.setText(String.valueOf(volume3));
                            break;
                    }
                }
            }
        });

    }


}