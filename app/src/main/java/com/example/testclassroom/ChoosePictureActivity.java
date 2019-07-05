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
import java.util.Objects;

public class ChoosePictureActivity extends AppCompatActivity {
    int PICK_IMAGE = 100;
    Uri imageUri;
    static String stringUri;
    ImageView imageViewChoosePicture;
    TextView textViewChoosePicture ;
    Button buttonSkip ;
    String pathImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_picture);

        //Drawable img = getResources().getDrawable(R.drawable.user);



        imageViewChoosePicture = findViewById(R.id.imageViewChoosePicture);
        buttonSkip = findViewById(R.id.button_skip);
        textViewChoosePicture = findViewById(R.id.textView_choose_photo) ;

        imageViewChoosePicture.setOnClickListener(v -> {
            pickFromGallery();
        });

        buttonSkip.setOnClickListener(v -> {
            Intent intent = new Intent(ChoosePictureActivity.this,ListOfClassActivity.class);
            startActivity(intent);
            if (textViewChoosePicture.getText().toString().equals("Skip")){
                new TransferMessage().execute("imageProfile:"+ WelcomeActivity.username + ":noImage") ;
            }
            else {
                //pathImage = getRealPathFromURI(imageUri);
                //String stringURI = getBase64String();
                new TransferMessage().execute("imageProfile:" + WelcomeActivity.username + ":" + "imageTest");
            }
        });


    }

    private void pickFromGallery() {
        Log.e("TagPick" , "picked");
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = Objects.requireNonNull(data).getData();
            Log.e("imageURI" , "test");
            imageViewChoosePicture.setImageURI(imageUri);
            stringUri = imageUri.toString();
            textViewChoosePicture.setText("Image Added Successfully!");
            buttonSkip.setText("Next");

        }
    }

    private String getBase64String() {

        // give your image file url in mCurrentPhotoPath
        Bitmap bitmap = BitmapFactory.decodeFile(pathImage);


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // In case you want to compress your image, here it's at 40%
        bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();

        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    public String getRealPathFromURI(Uri contentUri) {

        // can post image
        String [] proj={MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery( contentUri,
                proj, // Which columns to return
                null,       // WHERE clause; which rows to return (all rows)
                null,       // WHERE clause selection arguments (none)
                null); // Order-by clause (ascending by name)
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();

        return cursor.getString(column_index);
    }


}
