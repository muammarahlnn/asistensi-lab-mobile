package com.example.task4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;

import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    TextInputEditText edUser,edName;
    TextInputLayout lUser,lName;
    CircleImageView uImage;
    Button sButton;
    private static final int RESULT_IMG = 1;

    Uri selectedImage;


    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edUser = findViewById(R.id.inputUserEdit);
        edName = findViewById(R.id.inputNameEdit);
        lName = findViewById(R.id.inputLayoutName);
        lUser = findViewById(R.id.inputLayoutUser);
        uImage = findViewById(R.id.profile_image);
        sButton = findViewById(R.id.BSubmit);

        sButton.setOnClickListener(view -> {
            if (TextUtils.isEmpty(Objects.requireNonNull(edUser.getText()).toString()) && TextUtils.isEmpty(Objects.requireNonNull(edName.getText()).toString()) && uImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.ic_launcher_background).getConstantState()){
                Toast.makeText(this, "Upload image first", Toast.LENGTH_SHORT).show();
                edUser.setError("Required");
                edName.setError("Required");
            } else if (TextUtils.isEmpty(edUser.getText().toString()) && TextUtils.isEmpty(Objects.requireNonNull(edName.getText()).toString())) {
                edUser.setError("Required");
                edName.setError("Required");
            } else if (uImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.ic_launcher_background).getConstantState() && TextUtils.isEmpty(Objects.requireNonNull(edName.getText()).toString())) {
                Toast.makeText(this, "Upload image first", Toast.LENGTH_SHORT).show();
                edName.setError("Required");
            }else if (uImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.ic_launcher_background).getConstantState() && TextUtils.isEmpty(edUser.getText().toString())) {
                Toast.makeText(this, "Upload image first", Toast.LENGTH_SHORT).show();
                edUser.setError("Required");
            }else if (uImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.ic_launcher_background).getConstantState()) {
                Toast.makeText(this, "Upload image first", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(edUser.getText().toString())) {
                edUser.setError("Required");
            } else if (TextUtils.isEmpty(Objects.requireNonNull(edName.getText()).toString())) {
                edName.setError("Required");
            }else {
                Intent KePost = new Intent(getApplicationContext(), PostActivity.class);
                String user = edUser.getText().toString();
                String name = edName.getText().toString();
                KePost.putExtra("Uname" , user);
                KePost.putExtra("Fname" , name);
                KePost.putExtra("image" ,selectedImage);
                startActivity(KePost);
            }
        });

        uImage.setOnClickListener(view -> {
            Intent uplImage = new Intent(Intent.ACTION_PICK);
            uplImage.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(uplImage,RESULT_IMG);

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_IMG && resultCode == RESULT_OK){

            selectedImage = Objects.requireNonNull(data).getData();
            uImage.setImageURI(selectedImage);
        }
    }
}