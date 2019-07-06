package com.example.testclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileHomeworkStudentActivity extends AppCompatActivity {

    static String homeworkProfileResult = "";

    Button buttonMarkAsDone;
    EditText editTextPrivateComment, editTextAttachment;
    TextView textViewHomeworkName, textViewAssignment , textViewPublicComment;
    ImageView imageViewBack;
    String name = "", comments = "", assignments = "";
    ImageView imageViewSend ;

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
        imageViewSend = findViewById(R.id.action_send_comment) ;

        imageViewBack.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileHomeworkStudentActivity.this, ListOfHomeworkActivity.class);
            startActivity(intent);
        });

        textViewPublicComment.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileHomeworkStudentActivity.this,ListOfCommentsActivity.class);
            intent.putExtra("homeworkCode",homeworkCode);
            startActivity(intent);
        });


        textViewHomeworkName.setText(name);
        textViewAssignment.setText(assignments);
        showComments(comments);

        imageViewSend.setOnClickListener(v -> {
            if(!editTextPrivateComment.getText().toString().equals("")){
                String s = "addPrivateComment:" + homeworkCode + ":" + WelcomeActivity.username + ":" + editTextPrivateComment.getText().toString();
                new TransferMessage().execute(s) ;
            }
            else  {
                Toast.makeText(ProfileHomeworkStudentActivity.this,"Enter Something :| " ,Toast.LENGTH_SHORT).show();
            }
        });


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
