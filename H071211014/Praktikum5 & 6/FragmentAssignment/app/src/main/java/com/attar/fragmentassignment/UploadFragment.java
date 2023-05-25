package com.attar.fragmentassignment;

import android.content.Context;
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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class UploadFragment extends Fragment {

    private static UploadFragment instance;

    public static UploadFragment getInstance(){
        if (instance == null){
            instance = new UploadFragment();
        }
        return instance;
    }
    private ImageView ivPost;

    private User user;
    private UploadPostListener uploadPostListener;


    private ActivityResultLauncher<Intent> launcherIntentPhotos;

    @Override
    public void onAttach (@NonNull Context context) {
        super.onAttach(context);
        this.uploadPostListener = HomeFragment.getInstance().getUploadPostListener();
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        launcherIntentPhotos = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result){
                    if (result != null) {
                        Uri imageUri = result.getData().getData();
                        user.getPost().setPhotoUri(imageUri);
                        ivPost.setImageURI(imageUri);
                    }
                }
            }
        );
        return inflater.inflate(R.layout.fragment_upload, container, false);
    }

    @Override
    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        user = new User("Attar", "AttarM", R.drawable.profilelogo, new Post());

        ivPost = view.findViewById(R.id.ivPost);
        ivPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intentPicker = new Intent(Intent.ACTION_GET_CONTENT);
                intentPicker.setType("image/*");
                launcherIntentPhotos.launch(Intent.createChooser(intentPicker, "Choose a Photo"));
            }
        });


        Button btnUpload = view.findViewById(R.id.btnUpload);
        btnUpload.setOnClickListener(view1 -> {
            if (user.getPost().getPhotoUri() == null) {
                Toast.makeText(getActivity(), "Please pick a photo first", Toast.LENGTH_SHORT).show();
                return;
            }

            TextView tvCaption = view.findViewById(R.id.tvCaption);
            String caption = tvCaption.getText().toString().trim();

            user.getPost().setCaption(caption);
            if(uploadPostListener != null){
                uploadPostListener.onPostUploaded(user);

                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, HomeFragment.getInstance(), HomeFragment.class.getSimpleName())
                        .commit();

                Toast.makeText(getContext(), "Post Success", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDetach () {
        super.onDetach();
        uploadPostListener = null;
    }

    public interface UploadPostListener{
        void onPostUploaded(User user);
    }
}