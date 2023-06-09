package com.example.kuis;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

Button btnApply;
ImageView Profil;
EditText etName;
Photo profil;
boolean isEmpty = false;


    private ActivityResultLauncher<Intent> imageCaptureLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if(result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Uri selectedPhoto = result.getData().getData();
                        Profil.setImageURI(selectedPhoto);
                        profil.setFotoUri(selectedPhoto);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profil = new Photo();
        btnApply = findViewById(R.id.btn_apply);
        Profil = findViewById(R.id.foto);
        etName = findViewById(R.id.name);

        Profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPicker = new Intent(Intent.ACTION_GET_CONTENT);
                intentPicker.setType("image/*");
                imageCaptureLauncher.launch(Intent.createChooser(intentPicker,"Choose a Photo"));
            }
        });

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (profil.getFotoUri() == null){
                    Toast.makeText(MainActivity.this, "Pick Your Profil First", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(etName.getText().toString().isEmpty()){
                    etName.setError("field ini tidak boleh kosong!");
                    Toast.makeText(MainActivity.this, "Enter Your Full Name", Toast.LENGTH_SHORT).show();
                    isEmpty = true;
                }
                if(!isEmpty){
                    Intent intent = new Intent(MainActivity.this, Score.class);
                    intent.putExtra("FULL NAME", etName.getText().toString());
                    intent.putExtra("PROFIL", profil);
                    startActivity(intent);
                }
            }
        });


    }
}