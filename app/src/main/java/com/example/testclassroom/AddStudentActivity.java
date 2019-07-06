package com.example.testclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.Inet4Address;

public class AddStudentActivity extends AppCompatActivity {
    EditText username;
    Button submit;
    static String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        username = findViewById(R.id.editText_username_student);
        submit = findViewById(R.id.button_submit_teacher);

        submit.setOnClickListener(v -> {
            new TransferMessage().execute("addStudent:" +  ListOfHomeworkActivity.classCode + ":" + username.getText().toString());
        });

        if (!result.equals("")) {
            Toast.makeText(AddStudentActivity.this, result, Toast.LENGTH_SHORT).show();
        }
    }
}
