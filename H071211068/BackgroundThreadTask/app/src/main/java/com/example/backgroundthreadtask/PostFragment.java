package com.example.backgroundthreadtask;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.backgroundthreadtask.data.model.Post;
import com.example.backgroundthreadtask.data.model.User;

import java.util.ArrayList;

public class PostFragment extends Fragment {
    private ImageView iv_post;
    private EditText tv_capt;
    private Button bt_upload;
    private User user;


    private ActivityResultLauncher<Intent> launcherIntentImage = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == -1 && result.getData() != null){
                        Uri selectedPhoto = result.getData().getData();
                        iv_post.setImageURI(selectedPhoto);
                        Uri fileUri = result.getData().getData();
                        user.getPost().setImg_post(fileUri);


                    }

                }
            }
    );

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        iv_post = view.findViewById(R.id.iv_pict);
        tv_capt = view.findViewById(R.id.et_capt);
        bt_upload = view.findViewById(R.id.btn_uploud);
        user = new User("mikeyy","mikeyyyyyyyyy",R.drawable.pa_san, new Post());
        iv_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                launcherIntentImage.launch(intent);
            }
        });

        bt_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((iv_post.getDrawable().getConstantState() == ResourcesCompat.getDrawable(getResources(), R.drawable.baseline_image_24, null).getConstantState())) {
                    Toast.makeText(getContext(), "Upload Image First", Toast.LENGTH_SHORT).show();
                } else {
                    String capt = tv_capt.getText().toString();

                    user.getPost().setCaption(capt);

                    HomeFragment.dataSource2.addUser(user);
                    HomeFragment homeFragment = new HomeFragment();
                    tv_capt.setText("");
                    iv_post.setImageURI(null);

                    FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, homeFragment);
                    transaction.commit();
                }
            }
        });
    }

}