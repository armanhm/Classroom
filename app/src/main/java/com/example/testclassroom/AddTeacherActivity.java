package com.example.testclassroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTeacherActivity extends AppCompatActivity {
    EditText username;
    Button submit;
    static String result = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);
        username = findViewById(R.id.editText_username_teacher);
        submit = findViewById(R.id.button_submit_student);
        submit.setOnClickListener(v -> {
            new TransferMessage().execute("addTeacher:" +  ListOfHomeworkActivity.classCode + ":" + username.getText().toString());
        });

        if (!result.equals("")) {
            Toast.makeText(AddTeacherActivity.this, result, Toast.LENGTH_SHORT).show();
        }
    }
}
