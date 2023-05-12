package com.example.inigaram;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
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

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class PostFragment extends Fragment {
    ImageView postImage;
    EditText postText;
    Button uploadButton;
    String imageUri;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        postImage = view.findViewById(R.id.post_iv);
        postText = view.findViewById(R.id.post_et);
        uploadButton = view.findViewById(R.id.upload_button);



        postImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentPicker = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                intentPicker.setType("image/*");
                launcherIntentPhotos.launch(Intent.createChooser(intentPicker, "Choose a photo"));
            }
        });

        uploadButton.setOnClickListener(btn -> {
            if (imageUri != null) {
                Post newPost = new Post("Rahmatullah Rahman", "fnilvuwu", imageUri, postText.getText().toString(), null); // create a new Post object
                DataSource.posts.add(newPost);
                Toast.makeText(getContext(), "Post success!", Toast.LENGTH_SHORT).show();

                HomeFragment homeFragment = new HomeFragment();
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, homeFragment,
                                HomeFragment.class.getSimpleName())
                        .addToBackStack(null)
                        .commit();
            }
            else {
                Toast.makeText(getContext(), "Please pick a photo first", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ActivityResultLauncher<Intent> launcherIntentPhotos = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    // do something when done picking photo
                    if (result.getData() != null && result.getResultCode() == RESULT_OK) {
                        Uri uri = result.getData().getData();
                        imageUri = uri.toString();
                        postImage.setImageURI(uri);
                    }

                }
            }
    );
}