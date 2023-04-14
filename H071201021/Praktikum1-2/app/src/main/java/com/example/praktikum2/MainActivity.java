package com.example.praktikum2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);

//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.bangun_ruang, android.R.layout.simple_spinner_item);

//        adapter.setDropDownViewResource(R.layout.spinner);

//        spinner.setAdapter(adapter);
        EditText editText1 = findViewById(R.id.editTextNumber);
        EditText editText2 = findViewById(R.id.editTextNumber2);
        EditText editText3 = findViewById(R.id.editTextNumber3);
        TextView hasil = findViewById(R.id.textView2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getItemAtPosition(position).toString();
                Button button = findViewById(R.id.button);

                if (selected.equals("Bola")) {
                    editText1.setHint("Jari - jari");
                    editText2.setVisibility(View.GONE);
                    editText3.setVisibility(View.GONE);
                    hasil.setText("Hasil");

                    button.setOnClickListener(v -> {
                        if (!(checkEditTextsEmpty(editText1))) {
                            double jari = Double.parseDouble(editText1.getText().toString());
                            double volume = (double) 4/3 * Math.PI * Math.pow(jari, 3);
                            hasil.setText(String.format("%.2f", volume));
                        }
                    });
                }

                if (selected.equals("Kerucut")) {
                    editText1.setHint("Jari - jari");
                    editText3.setVisibility(View.VISIBLE);
                    editText2.setVisibility(View.GONE);
                    hasil.setText("Hasil");

                    button.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            if (!(checkEditTextsEmpty(editText1, editText3))) {
                                double tinggi = Double.parseDouble(editText3.getText().toString());
                                double jari = Double.parseDouble(editText1.getText().toString());
                                double volume = (double) 1/3 * Math.PI * Math.pow(jari, 2) * tinggi;
                                hasil.setText(String.format("%.2f", volume));
                            }
                        }
                    });
                }

                if (selected.equals("Balok")) {
                    editText1.setHint("Panjang");
                    editText2.setVisibility(View.VISIBLE);
                    editText3.setVisibility(View.VISIBLE);
                    hasil.setText("Hasil");
                    button.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            if (!(checkEditTextsEmpty(editText1, editText2, editText3))) {
                                double panjang = Double.parseDouble(editText1.getText().toString());
                                double lebar = Double.parseDouble(editText2.getText().toString());
                                double tinggi = Double.parseDouble(editText3.getText().toString());
                                double volume = (double) panjang * lebar * tinggi;
                                hasil.setText(String.format("%.2f", volume));
                            }
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no op
            }
        });

    }

    public boolean checkEditTextsEmpty(EditText... editTexts) {
        for (EditText editText : editTexts) {
            if (editText.getText().toString().isEmpty()) {
                editText.setError("Field ini tidak boleh kosong");
                return true;
            }
        }
        return false;
    }

}