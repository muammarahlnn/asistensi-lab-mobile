package com.example.fragment;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class UploadFragment extends Fragment {

    private Uri selectedPictureUri;
    private ImageView picture;
    private TextView caption;
    private Button Upload;

    private  ModelClass data;
    private static final int PICK_IMAGE_REQUEST = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_upload, container, false);
        selectedPictureUri = null;

        picture = view.findViewById(R.id.uploadpic);
        caption = view.findViewById(R.id.caption);
        Upload = view.findViewById(R.id.sentpost);

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_IMAGE_REQUEST);
            }
        });

        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                if (selectedPictureUri == null) {
                    Toast.makeText(getActivity(), "Gambar belum dipilih!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Mengambil caption dari EditText
                String captionText = caption.getText().toString();

                // Membuat instance dari ModelClass dengan data gambar dan caption
                data= new ModelClass(selectedPictureUri.toString(), captionText);

                // Membuat instance dari HomeFragment
                HomeFragment homeFragment = HomeFragment.newInstance(data);

                // Mengirim data menggunakan argumen

                args.putParcelable("data", data);
                homeFragment.setArguments(args);


                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, homeFragment)
                        .addToBackStack(null)
                        .commit();
            }

        });
        return view;
    }

    @Override
    public void onActivityResult ( int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        // Di dalam method onActivityResult
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            selectedPictureUri = data.getData();
            // Set gambar ke ImageView jika perlu
            picture.setImageURI(selectedPictureUri);
        }
    }
}
