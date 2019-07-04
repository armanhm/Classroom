package com.example.testclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileHomeworkActivity extends AppCompatActivity {

    static String homeworkProfileResult = "";

    Button buttonMarkAsDone;
    EditText editTextPrivateComment, editTextAttachment;
    TextView textViewHomeworkName, textViewAssignment , textViewPublicComment;
    ImageView imageViewBack;
    String name = "", comments = "", assignments = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_homework);

        String homeworkCode = getIntent().getStringExtra("homeworkCode");

        String request = "homeworkProfile:" + homeworkCode;
        new TransferMessage().execute(request);

        if (!homeworkProfileResult.equals("")) {
            String[] parrams = homeworkProfileResult.split(":");
            name = parrams[2];
            comments = parrams[3];
            assignments = parrams[4];
        }



        buttonMarkAsDone = findViewById(R.id.button_mark_as_done);
        editTextPrivateComment = findViewById(R.id.editText_private_comment);
        editTextAttachment = findViewById(R.id.editText_attachment);
        textViewPublicComment = findViewById(R.id.textView_public_comment);
        textViewHomeworkName = findViewById(R.id.textView_homework_name);
        textViewAssignment = findViewById(R.id.textView_show_assignment);
        imageViewBack = findViewById(R.id.imageView_back);

        imageViewBack.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileHomeworkActivity.this, ListOfHomeworkActivity.class);
            startActivity(intent);
        });

        textViewPublicComment.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileHomeworkActivity.this,ListOfCommentsActivity.class);
            intent.putExtra("homeworkCode",homeworkCode);
            startActivity(intent);
        });

        textViewHomeworkName.setText(name);
        textViewAssignment.setText(assignments);
        showComments(comments);
    }

    private void showComments(String comments) {
        String [] params = comments.split("@");
        int size = params.length;
        if (size <= 1){
            textViewPublicComment.setText("No comments yet!");
        }
        else {
            textViewPublicComment.setText(size + " comments");
        }
    }
}
