package com.example.testclassroom;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Objects;

public class ChoosePictureActivity extends AppCompatActivity {
    int PICK_IMAGE = 1;
    ImageView imageViewChoosePicture;
    TextView textViewChoosePicture ;
    Button buttonSkip ;
    Bitmap bitmap;
    Uri path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_picture);

        Drawable img = getResources().getDrawable(R.drawable.user);



        imageViewChoosePicture = findViewById(R.id.imageViewChoosePicture);
        buttonSkip = findViewById(R.id.button_skip);
        textViewChoosePicture = findViewById(R.id.textView_choose_photo) ;

        imageViewChoosePicture.setOnClickListener(v -> {
            pickFromGallery();
        });

        buttonSkip.setOnClickListener(v -> {
            if (textViewChoosePicture.getText().toString().equals("Skip")){
                new TransferMessage().execute("imageProfile:"+ WelcomeActivity.username + ":noImage") ;
            }
            else {
                new TransferMessage().execute("imageProfile:" + WelcomeActivity.username + ":" + "testImage");
                new TransferMessage().execute(imageToString(bitmap));
            }
            Intent intent = new Intent(ChoosePictureActivity.this,ListOfClassActivity.class);
            startActivity(intent);
        });


    }

    private void pickFromGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE && data != null) {
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            imageViewChoosePicture.setImageURI(path);
            textViewChoosePicture.setText("Image Added Successfully!");
            buttonSkip.setText("Next");
        }
    }

    private String imageToString(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,20,byteArrayOutputStream);
        byte[] imgBytes = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgBytes,Base64.DEFAULT);
    }


}
