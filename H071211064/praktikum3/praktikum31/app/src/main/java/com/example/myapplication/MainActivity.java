package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final int PICK_IMAGE = 1;

    private Profile profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profile = new Profile();
    }
    public void changePhoto(View view){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null){

            Uri imageUri = data.getData();
            profile.setImageUri(imageUri);
            ImageView imageView = findViewById(R.id.place_holder);
            imageView.setImageURI(imageUri);
            EditText fullName = findViewById(R.id.full_name);
            EditText userName = findViewById(R.id.username);
            Button nextButton = findViewById(R.id.submit);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String fullNameText = fullName.getText().toString();
                    String userNameText = userName.getText().toString();
                    boolean isEmpty = false;
                    if(fullName.getText().toString().isEmpty()) {
                        fullName.setError("Please fill this field");
                        isEmpty = true;
                    }

                    if(userName.getText().toString().isEmpty()){
                        userName.setError("Please fill this field");
                        isEmpty = true;
                    }

                    if(!isEmpty){
                        profile.setFullName(fullNameText);
                        profile.setUserName(userNameText);
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("profile", profile);
                        startActivity(intent);
                    }
                }
            });
        }
        }
}