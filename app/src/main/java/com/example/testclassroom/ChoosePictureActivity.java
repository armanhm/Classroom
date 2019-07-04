package com.example.testclassroom;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class ChoosePictureActivity extends AppCompatActivity {
    int PICK_IMAGE = 100;
    Uri imageUri;
    static String stringUri;
    ImageView imageViewChoosePicture;
    TextView textViewChoosePicture ;
    Button buttonSkip ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_picture);
        imageViewChoosePicture = findViewById(R.id.imageViewChoosePicture);
        buttonSkip = findViewById(R.id.button_skip);
        textViewChoosePicture = findViewById(R.id.textView_choose_photo) ;

        imageViewChoosePicture.setOnClickListener(v -> {
            pickFromGallery();
        });


    }

    private void pickFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = Objects.requireNonNull(data).getData();
            imageViewChoosePicture.setImageURI(imageUri);
            stringUri = imageUri.toString();
            textViewChoosePicture.setText("Image Added Successfully!");
            buttonSkip.setText("Next");

        }
    }


}
