package com.example.praktikum4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    String profileUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submitButton = (Button)findViewById(R.id.submitButton);
        EditText editTextFullname = findViewById(R.id.editTextFullname);
        EditText editTextUsername = findViewById(R.id.editTextUsername);
        CircleImageView profileImage = findViewById(R.id.profileImage);
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toastWarning = Toast.makeText(context, "Please pick a profile image first!", duration);

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(!(profileUri == null)) {
                    if(!checkEditTextsEmpty(editTextFullname, editTextUsername)) {
                        String stringFullname = editTextFullname.getText().toString();
                        String stringUsername = editTextUsername.getText().toString();
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("stringFullname", stringFullname);
                        intent.putExtra("stringUsername", stringUsername);
                        intent.putExtra("PROFILE_IMAGE_URI", profileUri);
                        startActivity(intent);
                    }
                }
                else {
                    toastWarning.show();
                }
            }

        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            profileUri = uri.toString();

            CircleImageView profileImage = findViewById(R.id.profileImage);
            profileImage.setImageURI(uri);
            // Do something with the image URI
        }
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