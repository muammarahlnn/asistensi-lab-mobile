package com.example.fragment1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class PostFragment extends Fragment {
    private EditText caption;
    private Button btn_upload;
    private ImageView imgPost;
    PostModel myItem;

    ActivityResultLauncher<Intent> launcherIntentImage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        launcherIntentImage = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Log.d("masuk onActivityResult","onActivityResult");
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Log.d("masuk if","if fe");
                        Uri selectedPhoto = result.getData().getData();
                        myItem.setImagePick(selectedPhoto);
                        imgPost.setImageURI(myItem.getImagePick());
                    }
                });
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_upload = view.findViewById(R.id.uploadBtn);
        caption = view.findViewById(R.id.captionText);
        imgPost = view.findViewById(R.id.pickPhoto);
        myItem = new PostModel();

        imgPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                i.setType("image/*");
                launcherIntentImage.launch(Intent.createChooser(i, "Choose a photo"));
            }
        });

        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String capt = caption.getText().toString().trim();
                myItem.setCaptionPost(capt);



                caption.setText("");
                if (myItem.getImagePick() == null){
                    Toast.makeText(getActivity(), "Please pick a photo", Toast.LENGTH_SHORT).show();
                    return;
                }

                Bundle bundle = new Bundle();
                bundle.putParcelable("postingan", myItem);
                HomeFragment homeFragment = new HomeFragment();
                homeFragment.setArguments(bundle);
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, homeFragment);
                transaction.commit();
            }
        });
    }

}
