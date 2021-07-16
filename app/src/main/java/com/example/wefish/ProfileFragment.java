package com.example.wefish;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.fishingapp.R;

public class ProfileFragment extends Fragment {
    private static final int CAMERA_PERM_CODE = 101;
    private static final int CAMERA_REQUEST_CODE = 102;

    ImageView imageView;
    Button button;
    Button logBookBut;


    private static final int permissionID = 100;
    private static final int picID = 101;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        EditText nameEditText =view.findViewById(R.id.NameEditText);
        EditText surnameEditText =view.findViewById(R.id.SurnameEditText);
        EditText emailEditText =view.findViewById(R.id.EmailEditText);

        imageView = view.findViewById(R.id.imageViewPP);
        button = view.findViewById(R.id.PickImgButton);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                askCameraPermissions();
            }
        });

        logBookBut = view.findViewById(R.id.logBookButton);
        logBookBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goActivity();
            }
        });



        return view;
    }





    public void goActivity(){
        Intent intent = new Intent(getActivity(), LogBookActivity.class) ;
        startActivity(intent);
    }

    private void askCameraPermissions() {
        if(ContextCompat.checkSelfPermission(getContext() ,Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),new String[] {Manifest.permission.CAMERA}, CAMERA_PERM_CODE);
        }else{
            openCamera();
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == CAMERA_PERM_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //openCamera();
            }else{

            }
        }
    }

    private void openCamera() {
            Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(camera,CAMERA_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == CAMERA_REQUEST_CODE){
            Bitmap image = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(image);
        }
    }
}
