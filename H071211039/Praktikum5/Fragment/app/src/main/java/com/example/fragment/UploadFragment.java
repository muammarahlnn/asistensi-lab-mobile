package com.example.fragment;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class UploadFragment extends Fragment {

    private ImageView imgPost;
    private EditText etCaption;
    private Button btnUpload;
    private Home home;
    private ActivityResultLauncher<Intent> imageCaptureLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if(result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Uri selectedPhoto = result.getData().getData();
                        imgPost.setImageURI(selectedPhoto);
                        home.setPhotoUri(selectedPhoto);
                    }
                }
            }
    );

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upload, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        home = new Home();
        home.setFullName("isty Hamdayani");
        home.setUsername("Iniiisty");
        home.setProfile(R.drawable.foto1);

        imgPost = view.findViewById(R.id.imgPost);
        etCaption = view.findViewById(R.id.etCaption);
        btnUpload = view.findViewById(R.id.btnUpload);

        imgPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPicker = new Intent(Intent.ACTION_GET_CONTENT);
                intentPicker.setType("image/*");
                imageCaptureLauncher.launch(Intent.createChooser(intentPicker,"Choose a Photo"));
            }
        });

       btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (home.getPhotoUri() == null){
                    Toast.makeText(getActivity(), "Please pick a post photo", Toast.LENGTH_SHORT).show();
                    return;
                }

                String caption = String.valueOf(etCaption.getText());
                home.setCaption(caption);
                DataSource.homes.add(home);

                HomeFragment homeFragment = new HomeFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, homeFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

    }
}