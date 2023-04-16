package com.example.parcelablequiz;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void changePhoto(View view){
        //Taking Resource From Gallery
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        //Set Type Image
        intent.setType("image/*");
        //Taking Data From Gallery
        startActivityForResult(intent.createChooser(intent,"Select Image"), PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        ImageView placeHolder = findViewById(R.id.place_holder);
        EditText name = findViewById(R.id.name);
        Button startBtn = findViewById(R.id.startBtn);
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null){
            Uri imageUri = data.getData();
            placeHolder.setImageURI(imageUri);

            startBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    String userName = name.getText().toString();
                    User user = new User(userName, 0);
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("user", user);
                    intent.putExtra("imageProfile", imageUri.toString());
                    startActivity(intent);
                }
            });
        }
    }
}