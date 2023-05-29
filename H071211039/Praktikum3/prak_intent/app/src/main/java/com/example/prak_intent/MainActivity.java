package com.example.prak_intent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText FullName, Username;
    Button Submit;
    String full_name,username;
    boolean isEmpty= false;
    ImageView Profil;
    Photo photo;
    private ActivityResultLauncher<Intent> imageCaptureLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if(result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Uri selectedPhoto = result.getData().getData();
                        Profil.setImageURI(selectedPhoto);
                        photo.setFotoUri(selectedPhoto);
                    }
                }
            }
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photo = new Photo();
        Profil = findViewById(R.id.profil);
        FullName = findViewById(R.id.full_name);
        Username = findViewById(R.id.username);
        Submit = findViewById(R.id.submit);

        Profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPicker = new Intent(Intent.ACTION_GET_CONTENT);
                intentPicker.setType("image/*");
                imageCaptureLauncher.launch(Intent.createChooser(intentPicker,"Choose a Photo"));
            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                full_name = String.valueOf(FullName.getText());
                username = String.valueOf(Username.getText());

                if (photo.getFotoUri() == null){
                    Toast.makeText(MainActivity.this, "Pick Your Profil First", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(full_name)){
                    FullName.setError("field ini tidak boleh kosong!");
                    Toast.makeText(MainActivity.this, "Enter Your Full Name", Toast.LENGTH_SHORT).show();
                    isEmpty = true;
                }
                if(TextUtils.isEmpty(username)){
                    Username.setError("field ini tidak boleh kosong!");
                    Toast.makeText(MainActivity.this, "Enter Your Username ", Toast.LENGTH_SHORT).show();
                    isEmpty = true;
                }
                if(!isEmpty){
                    Intent intent = new Intent(MainActivity.this, UploadActivity.class);
                    intent.putExtra("FULL NAME", full_name);
                    intent.putExtra("USERNAME", username);
                    intent.putExtra("PROFIL", photo);
                    startActivity(intent);
                }


            }
        });



    }
    private void Submit (String fullname, String username){}


}

