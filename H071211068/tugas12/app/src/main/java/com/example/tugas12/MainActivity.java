package com.example.tugas12;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.Transliterator;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.String;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

//    EditText mEditjari;
//    EditText mEditpanjang;
//    EditText mEditlebar;
//    EditText mEdittinggi;
EditText mEditjari,mEditpanjang,mEdittinggi,mEditlebar;
//    TextView mTextjari;
//    TextView mTextpanjang;
//    TextView mTextlebar;
//    TextView mTexttinggi;
    TextView mTextjari,mTextlebar,mTexttinggi,mTextpanjang,mTextResult;


//    TextView mTextResult;
    Button mButtonCount;

    String [] rumus = {"Bola", "kerucut","Balok"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, rumus);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        mEditjari = (EditText) findViewById(R.id.editjari);
        mEdittinggi = (EditText) findViewById(R.id.edittinggi);
        mEditlebar = (EditText) findViewById(R.id.editlebar);
        mEditpanjang = (EditText) findViewById(R.id.editpanjang);
        mTextResult = (TextView) findViewById(R.id.textResult);
        mTextjari = (TextView) findViewById(R.id.textjari);
        mTextpanjang = (TextView) findViewById(R.id.textpanjang);
        mTextlebar = (TextView) findViewById(R.id.textlebar);
        mTexttinggi = (TextView) findViewById(R.id.texttinggi);
        mButtonCount = (Button) findViewById(R.id.buttonCount);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        if(position == 0 ){
            mTextResult.setText("Hasil");
            mTexttinggi.setVisibility(View.GONE);
            mEdittinggi.setVisibility(View.GONE);
            mTextlebar.setVisibility(View.GONE);
            mEditlebar.setVisibility(View.GONE);
            mTextpanjang.setVisibility(View.GONE);
            mEditpanjang.setVisibility(View.GONE);
            mTextjari.setVisibility(View.VISIBLE);
            mEditjari.setVisibility(View.VISIBLE);


            mButtonCount.setOnClickListener(view1 -> {

                if (TextUtils.isEmpty(mEditjari.getText().toString())) {
                    mEditjari.setError("tidak boleh kosong");

                } else {
                    Double rad = Double.parseDouble(mEditjari.getText().toString());
                    Double calcBola = 22.0/7.0*rad*rad*rad*4.0/3.0;
                    mTextResult.setText(String.valueOf(calcBola));
                }
            });
        } else if (position == 1) {
            mTextResult.setText("Hasil");
            mTexttinggi.setVisibility(view.VISIBLE);
            mEdittinggi.setVisibility(view.VISIBLE);
            mTextjari.setVisibility(view.VISIBLE);
            mEditjari.setVisibility(view.VISIBLE);
            mTextlebar.setVisibility(view.GONE);
            mEditlebar.setVisibility(view.GONE);
            mTextpanjang.setVisibility(view.GONE);
            mEditpanjang.setVisibility(view.GONE);

            mButtonCount.setOnClickListener(view12 -> {

                if (TextUtils.isEmpty(mEdittinggi.getText().toString()) && TextUtils.isEmpty(mEditjari.getText().toString())) {
                    mEditjari.setError("tidak boleh kosong");
                    mEdittinggi.setError("tidak boleh kosong");

                } else if (TextUtils.isEmpty(mEdittinggi.getText().toString())) {
                    mEdittinggi.setError("tidak boleh kosong");

                } else if (TextUtils.isEmpty(mEdittinggi.getText().toString())) {
                    mEditjari.setError("tidak boleh kosong");

                } else {
                    Double rad = Double.parseDouble(mEditjari.getText().toString());
                    Double height = Double.parseDouble(mEdittinggi.getText().toString());
                    Double calcCone = 22.0/7.0*rad*rad*height*1.0/3.0;
                    mTextResult.setText(String.valueOf(calcCone));
                }
            });
        }else {
            mTextResult.setText("Hasil");
            mTextjari.setVisibility(view.INVISIBLE);
            mEditjari.setVisibility(view.INVISIBLE);
            mTextlebar.setVisibility(view.VISIBLE);
            mEditlebar.setVisibility(view.VISIBLE);
            mTextpanjang.setVisibility(view.VISIBLE);
            mEditpanjang.setVisibility(view.VISIBLE);
            mTexttinggi.setVisibility(view.VISIBLE);
            mEdittinggi.setVisibility(view.VISIBLE);

            mButtonCount.setOnClickListener(view13 -> {

                if (TextUtils.isEmpty(mEditlebar.getText().toString()) && TextUtils.isEmpty(mEdittinggi.getText().toString()) && TextUtils.isEmpty(mEditpanjang.getText().toString())){
                    mEditlebar.setError("tidak boleh kosong");
                    mEdittinggi.setError("tidak boleh kosong");
                    mEditpanjang.setError("tidak boleh kosong");

                } else if (TextUtils.isEmpty(mEditlebar.getText().toString()) && TextUtils.isEmpty(mEdittinggi.getText().toString())) {
                    mEditlebar.setError("tidak boleh kosong");
                    mEdittinggi.setError("tidak boleh kosong");
                } else if (TextUtils.isEmpty(mEditlebar.getText().toString()) && TextUtils.isEmpty(mEditpanjang.getText().toString())) {
                    mEditlebar.setError("tidak boleh kosong");
                    mEditpanjang.setError("tidak boleh kosong");
                } else if (TextUtils.isEmpty(mEdittinggi.getText().toString()) && TextUtils.isEmpty(mEditpanjang.getText().toString())) {
                    mEdittinggi.setError("tidak boleh kosong");
                    mEditpanjang.setError("tidak boleh kosong");
                } else if (TextUtils.isEmpty(mEditlebar.getText().toString())) {
                    mEditlebar.setError("tidak boleh kosong");

                } else if (TextUtils.isEmpty(mEdittinggi.getText().toString())) {
                    mEdittinggi.setError("tidak boleh kosong");

                }else if (TextUtils.isEmpty(mEditpanjang.getText().toString())) {
                    mEditpanjang.setError("tidak boleh kosong");

                } else {
                    Double height = Double.parseDouble(mEdittinggi.getText().toString());
                    Double width = Double.parseDouble(mEditlebar.getText().toString());
                    Double length = Double.parseDouble(mEditpanjang.getText().toString());
                    Double calcBalok = height*width*length;
                    mTextResult.setText(String.valueOf(calcBalok));
                }
            });
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}