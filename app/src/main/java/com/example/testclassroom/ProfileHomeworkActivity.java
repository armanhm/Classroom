package com.example.testclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileHomeworkActivity extends AppCompatActivity {

    static String homeworkProfileResult ;

    Button buttonMarkAsDone ;
    EditText editTextPrivateComment , editTextAttachment , editTextPublicComment ;
    TextView textViewClassName ,textViewAssignment ;
    ImageView imageViewBack ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_homework);

//        String request = "homeworkProfile:" + getIntent().getStringExtra("homeworkName") ;
//        new TransferMessage().execute(request);



        buttonMarkAsDone = findViewById(R.id.button_mark_as_done) ;
        editTextPrivateComment = findViewById(R.id.editText_private_comment);
        editTextAttachment = findViewById(R.id.editText_attachment);
        editTextPublicComment = findViewById(R.id.editText_add_comment);
        textViewClassName = findViewById(R.id.textViewClassName);
        textViewAssignment = findViewById(R.id.textView_show_assignment);
        imageViewBack = findViewById(R.id.imageView_back);




        imageViewBack.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileHomeworkActivity.this , ListOfHomeworkActivity.class);
            startActivity(intent);
        });
    }
}
