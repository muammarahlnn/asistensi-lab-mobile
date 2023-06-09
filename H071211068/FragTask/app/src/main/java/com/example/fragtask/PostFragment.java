package com.example.fragtask;

import static android.app.Activity.RESULT_OK;

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
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.provider.MediaStore;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.sql.DataSource;


public class PostFragment extends Fragment {

    EditText edCaption;
    Button btUpload;
    ImageView upImage;
    public static final String Key1 = "capt";

    private static final int RESULT_IMGUPL = 1;
    Uri selectedImage1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);

        edCaption = view.findViewById(R.id.inputCaption);
        btUpload = view.findViewById(R.id.BUpload);
        upImage = view.findViewById(R.id.imageUpl);

        btUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((upImage.getDrawable().getConstantState() == ResourcesCompat.getDrawable(getResources(), R.drawable.newpost, null).getConstantState())) {
                    Toast.makeText(getContext(), "Upload Image First", Toast.LENGTH_SHORT).show();
                } else {
                    String caption = edCaption.getText().toString();
                    Bundle bundle = new Bundle();
                    bundle.putString(PostFragment.Key1, caption);
                    bundle.putParcelable("img", selectedImage1);

                    HomeFragment homeFragment = new HomeFragment();
                    homeFragment.setArguments(bundle);

                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.Nfrag, homeFragment, "HomeFragment")
                            .addToBackStack(null)
                            .commit();
                }
            }
        });

        upImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent upIMG = new Intent(Intent.ACTION_PICK);
                upIMG.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(upIMG, RESULT_IMGUPL);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_IMGUPL && resultCode == RESULT_OK) {
            selectedImage1 = data.getData();
            upImage.setImageURI(selectedImage1);
        }
    }
}