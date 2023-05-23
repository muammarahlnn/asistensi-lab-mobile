package com.pmb.udingram;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pmb.udingram.databinding.FragmentAddPostBinding;

public class AddPostFragment extends Fragment {
    private static final int PICK_IMAGE_REQUEST = 1;
    FragmentAddPostBinding binding;
    Uri imagePost;
    UserPostData userPostData;
    Bundle bundle;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAddPostBinding.inflate(inflater, container, false);
        View v = binding.getRoot();
        Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.add_post_animation);
        binding.fragmentAddPost.startAnimation(anim);

        binding.postImg.setOnClickListener(v1 -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
        });


        binding.upladBtn.setOnClickListener(v1 -> {
            userPostData = new UserPostData(imagePost, binding.captionET.getText().toString());
            if (imagePost == null){
                Toast.makeText(getActivity(), "Gambar belum dipilih!", Toast.LENGTH_SHORT).show();
            }else {
                MainActivity mainActivity = (MainActivity) getActivity();
                bundle = new Bundle();
                bundle.putParcelable("postData", userPostData);
                assert mainActivity != null;
                HomeFragment homeFragment = mainActivity.homeFragment;
                homeFragment.setArguments(bundle);
                mainActivity.selectedMenu = "0";
                mainActivity.changeFragment(mainActivity.selectedMenu);
            }
            imagePost = null;
            binding.captionET.setText("");
        });

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && null != data) {
            imagePost = data.getData();
            binding.postImg.setImageURI(imagePost);
            binding.postImg.setScaleType(ImageView.ScaleType.CENTER_CROP);
            binding.postImg.setImageTintList(null);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}